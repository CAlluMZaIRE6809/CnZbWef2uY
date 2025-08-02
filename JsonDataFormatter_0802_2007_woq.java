// 代码生成时间: 2025-08-02 20:07:26
 * A simple JSON data formatter that converts JSON data into a more readable format using
 * Java and JSF framework.
 * 
 * @author Your Name
 * @version 1.0
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;

@ManagedBean
@SessionScoped
public class JsonDataFormatter {
    /*
    * Stores the JSON data to be formatted.
    */
    private String jsonData;
    
    /*
    * Stores the formatted JSON data.
    */
    private String formattedJsonData;
    
    /*
    * Gets the JSON data.
    *
    * @return The JSON data.
    */
    public String getJsonData() {
        return jsonData;
    }
    
    /*
    * Sets the JSON data.
    *
    * @param jsonData The JSON data to be set.
    */
    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
    
    /*
    * Gets the formatted JSON data.
    *
    * @return The formatted JSON data.
    */
    public String getFormattedJsonData() {
        return formattedJsonData;
    }
    
    /*
    * Sets the formatted JSON data.
    *
    * @param formattedJsonData The formatted JSON data to be set.
    */
    public void setFormattedJsonData(String formattedJsonData) {
        this.formattedJsonData = formattedJsonData;
    }
    
    /*
    * Formats the JSON data into a more readable format.
    */
    public void formatJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = objectMapper.readValue(jsonData, new TypeReference<Map<String, Object>>(){});
            this.formattedJsonData = objectMapper.writeValueAsString(map);
        } catch (IOException e) {
            // Handle JSON parsing error
            this.formattedJsonData = "Error parsing JSON data: " + e.getMessage();
        }
    }
}
