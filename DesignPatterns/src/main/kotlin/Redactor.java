import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Redactor extends JFrame {
    private Point pmin = new Point(0, 70);
    private Point pmax = new Point(800, 600);
    private PointF wmin = new PointF(0, 0);
    private PointF wmax = new PointF(1, 1);
    private float aspectRatio;

    private Point mousePosition = new Point();
    private boolean isDrawing = false;
    private boolean isZooming = false;
    private Point selectionStart = new Point();
    private Point selectionEnd = new Point();
    private Point zoomStart = new Point();
    private Point zoomEnd = new Point();

    private enum FigureType { LINE, RECT, ELLIPSE }
    private FigureType selectedFigureType = FigureType.LINE;
    private final List<Figure> figures = new ArrayList<>();
    private final Stack<Pair<PointF, PointF>> zoomHistory = new Stack<>();

    // Вспомогательный класс для пар
    static class Pair<A, B> {
        A first; B second;
        Pair(A a, B b) { first = a; second = b; }
    }

    static class PointF {
        float x, y;
        PointF(float x, float y) { this.x = x; this.y = y; }
    }

    static class Figure {
        PointF start, end;
        FigureType type;
        Figure(PointF s, PointF e, FigureType t) { start = s; end = e; type = t; }
    }

    static class Button {
        Rectangle bounds;
        String text;
        Runnable onClick;

        Button(int x, int y, int w, int h, String text, Runnable onClick) {
            this.bounds = new Rectangle(x, y, w, h);
            this.text = text;
            this.onClick = onClick;
        }
    }

    private  final List<Button> buttons = new ArrayList<>();
    private JPanel drawingPanel;

    public Redactor() {
        setTitle("Redactor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initButtons();
        initDrawingPanel();
    }

    private void initButtons() {
        buttons.add(new Button(10, 10, 150, 50, "Отмена зума", () -> {
            if (!zoomHistory.isEmpty()) {
                Pair<PointF, PointF> prev = zoomHistory.pop();
                wmax = prev.first;
                wmin = prev.second;
                drawingPanel.repaint();
            }
        }));

        buttons.add(new Button(170, 10, 150, 50, "Линия",
                () -> selectedFigureType = FigureType.LINE));
        buttons.add(new Button(330, 10, 150, 50, "Прямоугольник",
                () -> selectedFigureType = FigureType.RECT));
        buttons.add(new Button(490, 10, 150, 50, "Эллипс",
                () -> selectedFigureType = FigureType.ELLIPSE));
    }

    private void initDrawingPanel() {
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                // Рисуем рабочую область
                g2d.setColor(new Color(222, 222, 222));
                g2d.fillRect(pmin.x, pmin.y, pmax.x - pmin.x, pmax.y - pmin.y);

                // Рисуем фигуры
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(2));
                for (Figure f : figures) {
                    drawFigure(g2d, f);
                }

                // Рисуем панель инструментов
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, pmax.x, pmin.y);

                // Рисуем кнопки
                g2d.setColor(Color.BLACK);
                for (Button btn : buttons) {
                    g2d.drawRect(btn.bounds.x, btn.bounds.y,
                            btn.bounds.width, btn.bounds.height);
                    g2d.drawString(btn.text,
                            btn.bounds.x + 10,
                            btn.bounds.y + 30);
                }
            }

            private void drawFigure(Graphics2D g2d, Figure f) {
                Point start = worldToScreen(f.start);
                Point end = worldToScreen(f.end);

                switch (f.type) {
                    case LINE:
                        g2d.drawLine(start.x, start.y, end.x, end.y);
                        break;
                    case RECT:
                        g2d.drawRect(Math.min(start.x, end.x),
                                Math.min(start.y, end.y),
                                Math.abs(end.x - start.x),
                                Math.abs(end.y - start.y));
                        break;
                    case ELLIPSE:
                        g2d.drawOval(Math.min(start.x, end.x),
                                Math.min(start.y, end.y),
                                Math.abs(end.x - start.x),
                                Math.abs(end.y - start.y));
                        break;
                }
            }
        };

        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getY() < pmin.y) {
                    // Проверяем кнопки
                    for (Button btn : buttons) {
                        if (btn.bounds.contains(e.getPoint())) {
                            btn.onClick.run();
                            break;
                        }
                    }
                    return;
                }

                if (e.getButton() == MouseEvent.BUTTON1) {
                    isDrawing = true;
                    selectionStart = e.getPoint();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    isZooming = true;
                    zoomStart = e.getPoint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && isDrawing) {
                    isDrawing = false;
                    PointF startWorld = screenToWorld(selectionStart);
                    PointF endWorld = screenToWorld(selectionEnd);
                    figures.add(new Figure(startWorld, endWorld, selectedFigureType));
                    drawingPanel.repaint();
                } else if (e.getButton() == MouseEvent.BUTTON3 && isZooming) {
                    isZooming = false;
                    zoomHistory.push(new Pair<>(wmax, wmin));

                    Point bottomLeft = new Point(
                            Math.min(zoomStart.x, zoomEnd.x),
                            Math.max(zoomStart.y, zoomEnd.y)
                    );
                    Point topRight = new Point(
                            Math.max(zoomStart.x, zoomEnd.x),
                            Math.min(zoomStart.y, zoomEnd.y)
                    );

                    wmin = screenToWorld(bottomLeft);
                    wmax = screenToWorld(topRight);
                    drawingPanel.repaint();
                }
            }
        });

        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mousePosition = e.getPoint();

                if (isDrawing) {
                    selectionEnd = mousePosition;
                    drawingPanel.repaint();
                }

                if (isZooming) {
                    // Сохраняем пропорции
                    int dx = zoomStart.x - mousePosition.x;
                    int dy = (int) Math.round(dx / aspectRatio);
                    zoomEnd = new Point(mousePosition.x, zoomStart.y - dy);
                    drawingPanel.repaint();
                }
            }
        });

        add(drawingPanel);
    }

    private Point worldToScreen(PointF p) {
        return new Point(
                pmin.x + (int)Math.round((p.x - wmin.x) * (pmax.x - pmin.x) / (wmax.x - wmin.x)),
                pmax.y - (int)Math.round((p.y - wmin.y) * (pmax.y - pmin.y) / (wmax.y - wmin.y))
        );
    }

    private PointF screenToWorld(Point p) {
        return new PointF(
                wmin.x + (p.x - pmin.x) * (wmax.x - wmin.x) / (pmax.x - pmin.x),
                wmin.y + (pmax.y - p.y) * (wmax.y - wmin.y) / (pmax.y - pmin.y)
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Redactor().setVisible(true);
        });
    }
}