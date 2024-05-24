package componentes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserFrame {

    private static JFrame frame;
    private static JPanel panelContenedor;
    private static JFileChooser fc;
    private static File file;

    public FileChooserFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        frame.setResizable(false);
        frame.setUndecorated(true);

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt .java .cpp .py)", "txt", "java", "cpp", "py");
        fc = new JFileChooser();
        fc.setFileFilter(filtro);

        panelContenedor = new JPanel(new BorderLayout());
        panelContenedor.add(fc, BorderLayout.CENTER);

        frame.add(panelContenedor);

        addEvents();
    }

    private void addEvents() {
        fc.addActionListener(e -> {
            if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
                file = null;
            } else if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
                file = fc.getSelectedFile();
            }
            frame.dispose();
        });
    }

    public String showFileChooserFrame() {
        frame.setVisible(true);

        while (file == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        return file.getAbsolutePath();
    }

    public static void main(String[] args) {
        String selectedFilePath = new FileChooserFrame().showFileChooserFrame();
        if (selectedFilePath != null) {
            System.out.println("Archivo seleccionado: " + selectedFilePath);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}
