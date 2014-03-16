/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn.shared;

import java.io.Serializable;

/**
 * @author YPolyanskyy
 *
 * This class represents Image, corresponding to the individual card.
 */
@SuppressWarnings("serial")
public class Image implements Serializable {

	private String imageId;		// Location of the image file in the datastore
	private String imageUri;
	
	public void setImageData(String id, String uri) {
		this.imageId = id;
		this.imageUri = uri;
	}
	
	public String getImageUri() {
		return this.imageUri;
	}
}
