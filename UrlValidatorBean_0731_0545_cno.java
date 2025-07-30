// 代码生成时间: 2025-07-31 05:45:57
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.net.URL;
import java.net.MalformedURLException;

/**
 * ManagedBean for validating URL links.
 */
@ManagedBean
@RequestScoped
public class UrlValidatorBean {

    /**
     * The URL to be validated.
     */
    private String urlToValidate;

    /**
     * Validates the provided URL.
     *
     * @return A boolean indicating whether the URL is valid or not.
     */
    public boolean validateUrl() {
        try {
            new URL(urlToValidate);
            return true; // URL is valid
        } catch (MalformedURLException e) {
            // URL is invalid
            return false;
        }
    }

    /**
     * Getter for the URL to be validated.
     *
     * @return The URL to be validated.
     */
    public String getUrlToValidate() {
        return urlToValidate;
    }

    /**
     * Setter for the URL to be validated.
     *
     * @param urlToValidate The URL to be validated.
     */
    public void setUrlToValidate(String urlToValidate) {
        this.urlToValidate = urlToValidate;
    }
}
