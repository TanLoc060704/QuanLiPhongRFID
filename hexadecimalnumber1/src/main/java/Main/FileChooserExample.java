package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileChooserExample {

    public static void main(String[] args) {
        // Đặt giao diện theo hệ điều hành
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FileChooserExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        SwingUtilities.invokeLater(() -> new FileChooserExample().createAndShowGUI());
    }

    void createAndShowGUI() {
        JFrame frame = new JFrame("File Chooser Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300); // Tăng kích thước cửa sổ
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Set a background color for the frame
        frame.getContentPane().setBackground(new Color(255, 255, 255)); // White background

        // Input file chooser
        JLabel inputFileLabel = new JLabel("Input File:");
        inputFileLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        inputFileLabel.setForeground(new Color(0, 51, 102)); // Dark blue text
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(inputFileLabel, gbc);

        JTextField inputFileField = new JTextField(30); // Tăng kích thước trường nhập liệu
        inputFileField.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102), 1)); // Dark blue border
        gbc.gridx = 1;
        frame.add(inputFileField, gbc);

        JButton inputFileButton = new JButton("Browse...");
        inputFileButton.setBackground(new Color(224, 255, 255)); // Dark blue background
        inputFileButton.setForeground(Color.BLACK); // White text
        inputFileButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        gbc.gridx = 2;
        frame.add(inputFileButton, gbc);

        // Output folder chooser
        JLabel outputFolderLabel = new JLabel("Output Folder:");
        outputFolderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        outputFolderLabel.setForeground(new Color(0, 51, 102)); // Dark blue text
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(outputFolderLabel, gbc);

        JTextField outputFolderField = new JTextField(30);
        outputFolderField.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102), 1)); // Dark blue border
        gbc.gridx = 1;
        frame.add(outputFolderField, gbc);

        JButton outputFolderButton = new JButton("Browse...");
        outputFolderButton.setBackground(new Color(224, 255, 255)); // Dark blue background
        outputFolderButton.setForeground(Color.BLACK); // White text
        outputFolderButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        gbc.gridx = 2;
        frame.add(outputFolderButton, gbc);

        // Customer and Order Number fields
        JLabel customerLabel = new JLabel("Customer:");
        customerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        customerLabel.setForeground(new Color(0, 51, 102)); // Dark blue text
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(customerLabel, gbc);

        JTextField customerField = new JTextField(30); // Tăng kích thước trường nhập liệu
        customerField.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102), 1)); // Dark blue border
        gbc.gridx = 1;
        frame.add(customerField, gbc);

        JLabel orderNumberLabel = new JLabel("DHH:");
        orderNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderNumberLabel.setForeground(new Color(0, 51, 102)); // Dark blue text
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(orderNumberLabel, gbc);

        JTextField orderNumberField = new JTextField(30); // Tăng kích thước trường nhập liệu
        orderNumberField.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102), 1)); // Dark blue border
        gbc.gridx = 1;
        frame.add(orderNumberField, gbc);

        // Run button
        JButton runButton = new JButton("Run");
        runButton.setBackground(new Color(0 ,238 ,118)); // Forest green background
        runButton.setForeground(Color.BLACK); // White text
        runButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        gbc.gridx = 1;
        gbc.gridy = 4;
        frame.add(runButton, gbc);

        // Action listeners for file choosers
        inputFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn File Excel");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    inputFileField.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        outputFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser folderChooser = new JFileChooser();
                folderChooser.setDialogTitle("Chọn Thư Mục Lưu File Đầu Ra");
                folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = folderChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFolder = folderChooser.getSelectedFile();
                    outputFolderField.setText(selectedFolder.getAbsolutePath());
                }
            }
        });

        // Action listener for Run button
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputFilePath = inputFileField.getText();
                String outputFolderPath = outputFolderField.getText();
                String customer = customerField.getText(); // Lấy giá trị khách hàng
                String DHH = orderNumberField.getText(); // Lấy giá trị DHH

                // Kiểm tra nếu thư mục đầu ra không được chọn
                if (outputFolderPath.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Vui lòng chọn thư mục đầu ra.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Tạo thư mục con cho khách hàng trong thư mục đầu ra
                File customerDir = new File(outputFolderPath, customer);
                if (!customerDir.exists()) {
                    customerDir.mkdirs(); // Tạo thư mục nếu không tồn tại
                }

                // Tạo thư mục con cho DHH trong thư mục khách hàng
                File dhhDir = new File(customerDir, DHH);
                if (!dhhDir.exists()) {
                    dhhDir.mkdirs(); // Tạo thư mục nếu không tồn tại
                }

                // Tạo đường dẫn cho file đầu ra
                File inputFile = new File(inputFilePath);
                String fileName = inputFile.getName();
                String baseName = fileName.substring(0, fileName.lastIndexOf('.')); // Lấy phần tên file mà không có phần mở rộng
                String extension = fileName.substring(fileName.lastIndexOf('.') + 1); // Lấy phần mở rộng
                String outputFileName = DHH + "_" + baseName + "." + extension; // Tạo tên file mới
                String outputFilePath = new File(dhhDir, outputFileName).getAbsolutePath();

                try {
                    // Đọc file Excel
                    FileInputStream inputStream = new FileInputStream(inputFilePath);
                    Workbook workbook = new XSSFWorkbook(inputStream);
                    Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên

                    // Thêm cột EPC Converted vào cuối cùng
                    int lastColumnIndex = sheet.getRow(0).getLastCellNum();
                    Row headerRow = sheet.getRow(0);
                    Cell newHeaderCell = headerRow.createCell(lastColumnIndex);
                    newHeaderCell.setCellValue("EPC Converted");

                    // Duyệt qua từng dòng và chuyển đổi giá trị trong cột EPC
                    Iterator<Row> rowIterator = sheet.iterator();
                    rowIterator.next(); // Bỏ qua dòng tiêu đề
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        Cell epcCell = row.getCell(2); // Giả sử cột EPC là cột thứ 3 (index = 2)
                        String epcValue = epcCell.getStringCellValue();

                        // Chuyển đổi EPC sang Hexadecimal
                        String epcConverted = convertToHexadecimal(epcValue);

                        // Thêm giá trị đã chuyển đổi vào cột EPC Converted
                        Cell newCell = row.createCell(lastColumnIndex);
                        newCell.setCellValue(epcConverted);
                    }

                    // Ghi file Excel đầu ra
                    FileOutputStream outputStream = new FileOutputStream(outputFilePath);
                    workbook.write(outputStream);
                    workbook.close();
                    outputStream.close();
                    inputStream.close();

                    JOptionPane.showMessageDialog(frame, "Chuyển đổi thành công! File đã được lưu tại: " + outputFilePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Đã xảy ra lỗi: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    // Hàm chuyển đổi EPC sang Hexadecimal
    private static String convertToHexadecimal(String epcValue) {
        // Đơn giản hóa việc chuyển đổi EPC sang Hexadecimal
        StringBuilder sb = new StringBuilder();
        for (char c : epcValue.toCharArray()) {
            sb.append(String.format("%02X", (int) c));
        }
        return sb.toString();
    }
}

