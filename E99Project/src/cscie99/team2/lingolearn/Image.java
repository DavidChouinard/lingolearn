/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn;

/**
 * @author YPolyanskyy
 *
 * This class represents Image, corresponding to the individual card.
 */
public class Image {

	private String imageId;		// Location of the image file in the datastore
	private String imageUri;
	
	public Image(String id, String uri) {
		this.imageId = id;
		this.imageUri = uri;
	}
	
	public String getImageUri() {
		return this.imageUri;
	}
}
