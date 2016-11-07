package g_code_generator_ui.model;

/**
 * EagleSMTComponent Class provides functionality for storing and manipulating component attributes
 * that have been generated by an Eagle PCB design
 * @author Justin Johnson
 *
 */
public class EagleSMTComponent extends SMTComponent{

	/**
	 * Constructor creates instance of EagleSMTComponent
	 * Component attributes and attribute titles are assigned
	 * @param attributes String array containing EagleSMTComponent attributes
	 */
	public EagleSMTComponent(String[] attributes) {
		super(attributes);
		super.attributeTitles = this.attributeTitles;
		if(attributes.length == ATTRIBUTE_COUNT){
			description = attributes[0];
			xCoordinate = attributes[1];
			yCoordinate = attributes[2];
			//add PCB's offset values to the x/y coordinates then convert back to String
			xCoordinate = Double.parseDouble(xCoordinate) + PCB_X_OFFSET + "";
			yCoordinate = Double.parseDouble(yCoordinate) + PCB_Y_OFFSET + "";
			rotation = attributes[3];
			value = attributes[4];
			packageType = attributes[5];
			isValidComponent = true;
		}
		else{
			isValidComponent = false;
		}
	}
	
	/**
	 * Returns true if total number of attributes matches the expected number of attributes
	 * If attribute list contains more/less than is expected, return false
	 * @return true if attributeList.length == this.ATTRIBUTE_COUNT
	 */
	public boolean isValidComponent(){
		return isValidComponent;
	}

	/**
	 * Get component description attribute
	 * @return String description of component
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Set component description attribute
	 * @param String description of component as String
	 */
	public void setDescription(String description) {
		this.description = attributeList[0] = description;
	}
	
	/**
	 * Get component X Coordinate
	 * @return String X Coordinate of component center
	 */
	public String getxCoordinate() {
		return this.xCoordinate;
	}
	
	/**
	 * Set component X Coordinate
	 * @param String xCoordinate of component center
	 */
	public void setxCoordinate(String xCoordinate) {
		this.xCoordinate = attributeList[1] = xCoordinate;
	}
	
	/**
	 * Get component Y Coordinate
	 * @return String Y Coordinate of component center
	 */
	public String getyCoordinate() {
		return yCoordinate;
	}
	
	/**
	 * Set component Y Coordinate
	 * @param String yCoordinate of component center
	 */
	public void setyCoordinate(String yCoordinate) {
		this.yCoordinate = attributeList[2] = yCoordinate;
	}
	
	/**
	 * Get component angle of rotation
	 * @return String rotation of component
	 */
	public String getRotation() {
		return rotation;
	}
	
	/**
	 * Set component angle of rotation
	 * @param String rotation of component
	 */
	public void setRotation(String rotation) {
		this.rotation = attributeList[3] = rotation;
	}
	
	/**
	 * Get value of component
	 * @return String value of component
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Set value of component
	 * @param String value o component
	 */
	public void setValue(String value) {
		this.value = attributeList[4] = value;
	}
	
	/**
	 * Get package type of component
	 * @return String packageType of component
	 */
	public String getPackageType() {
		return packageType;
	}
	
	/**
	 * Set package type of component
	 * @param String packageType of component
	 */
	public void setPackageType(String packageType) {
		this.packageType = attributeList[5] = packageType;
	}

	/**
	 * Return true if component is an IC that needs to have angle verified by Computer Vision
	 * @return
	 */
	public boolean isIC(){
		return isIC;
	}
	
	private String[] attributeTitles = {"Description", "X Coordinate", "Y Coordinate", "Rotation", "Value", "Package"};
	public static final int ATTRIBUTE_COUNT = 6;
	private String description;
	private String xCoordinate;
	private String yCoordinate;
	private String rotation;
	private String value;
	private String packageType;
	private boolean isValidComponent;
	private boolean isIC;
	
}
