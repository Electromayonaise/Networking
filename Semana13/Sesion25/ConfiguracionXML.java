import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConfiguracionXML {

    private String ip;
    private int puerto;
    private String origenImagenes;
    private String destinoImagenes;
    private String formatoImagenes;

    public void cargarConfiguracion(String archivoXML) {
        try {
            File file = new File(archivoXML);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            // Obtener la configuración de la red
            NodeList nodeListRed = doc.getElementsByTagName("red");
            Node nodeRed = nodeListRed.item(0);
            if (nodeRed.getNodeType() == Node.ELEMENT_NODE) {
                Element elementRed = (Element) nodeRed;
                ip = elementRed.getElementsByTagName("ip").item(0).getTextContent();
                puerto = Integer.parseInt(elementRed.getElementsByTagName("puerto").item(0).getTextContent());
            }

            // Obtener la configuración de las imágenes
            NodeList nodeListImagenes = doc.getElementsByTagName("imagenes");
            Node nodeImagenes = nodeListImagenes.item(0);
            if (nodeImagenes.getNodeType() == Node.ELEMENT_NODE) {
                Element elementImagenes = (Element) nodeImagenes;
                origenImagenes = elementImagenes.getElementsByTagName("origen").item(0).getTextContent();
                destinoImagenes = elementImagenes.getElementsByTagName("destino").item(0).getTextContent();
                formatoImagenes = elementImagenes.getElementsByTagName("formato").item(0).getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters para acceder a la configuración cargada
    public String getIp() {
        return ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getOrigenImagenes() {
        return origenImagenes;
    }

    public String getDestinoImagenes() {
        return destinoImagenes;
    }

    public String getFormatoImagenes() {
        return formatoImagenes;
    }

    // Método para probar la carga de configuración
    public static void main(String[] args) {
        ConfiguracionXML configuracionXML = new ConfiguracionXML();
        configuracionXML.cargarConfiguracion("config.xml");

        System.out.println("Configuración de red:");
        System.out.println("IP: " + configuracionXML.getIp());
        System.out.println("Puerto: " + configuracionXML.getPuerto());

        System.out.println("\nConfiguración de imágenes:");
        System.out.println("Origen: " + configuracionXML.getOrigenImagenes());
        System.out.println("Destino: " + configuracionXML.getDestinoImagenes());
        System.out.println("Formato: " + configuracionXML.getFormatoImagenes());
    }
}
