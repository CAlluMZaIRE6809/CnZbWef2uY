// 代码生成时间: 2025-07-30 18:13:33
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * Excel表格自动生成器
 * 该类负责生成Excel文件
 */
@Named("excelGenerator")
@ViewScoped
@FacesValidator("excelValidator")
public class ExcelGenerator implements Validator, Serializable {

    private List<Map<String, Object>> data; // 存储要写入Excel的数据

    // 设置数据
    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    // 获取数据
    public List<Map<String, Object>> getData() {
        return data;
    }

    /**
     * 验证数据是否有效
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        // 验证逻辑，例如：检查数据是否为空
        if (data == null || data.isEmpty()) {
            FacesMessage message = new FacesMessage("No data available to generate Excel.");
            throw new ValidatorException(message);
        }
    }

    /**
     * 生成Excel文件
     * @param outputStream Excel文件输出流
     * @throws IOException 如果写入文件时发生错误
     */
    public void generateExcel(OutputStream outputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(); // 创建Excel工作簿
        Sheet sheet = workbook.createSheet("Data Sheet"); // 创建工作表

        // 写入数据到Excel
        if (data != null) {
            int rowNum = 0;
            for (Map<String, Object> rowMap : data) {
                Row row = sheet.createRow(rowNum++);
                int cellNum = 0;
                for (Map.Entry<String, Object> cellMap : rowMap.entrySet()) {
                    Cell cell = row.createCell(cellNum++);
                    cell.setCellValue(cellMap.getKey() + ": " + cellMap.getValue().toString());
                }
            }
        }

        // 写入Excel到输出流
        workbook.write(outputStream);
        workbook.close();
    }
}
