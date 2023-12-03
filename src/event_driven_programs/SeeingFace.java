/**
 * 
 */
package event_driven_programs;
import object_oriented_graphics.Face;
/**
 * 
 */
public class SeeingFace extends Face {

	private static final long serialVersionUID = -609677295115460355L;

	/**
	 * 
	 */
	public SeeingFace(double size) {
		super(size);
	}
	
	public void defaultPupilsPosition() {
		getElement(3).setLocation(PUPIL_L_X, PUPIL_L_Y);
		getElement(4).setLocation(PUPIL_R_X, PUPIL_R_Y);
	}
	
	public void see(double xm, double ym, double lx, double ly, double rx, double ry) {
		double Delt_x_l = xm - lx;
		double Delt_y_l = ym - ly;
		double theta_l	= Math.atan(Delt_y_l / Delt_x_l);
		if (Delt_x_l > 0) {
			double delta_x	= this.RADIO * Math.cos(theta_l);
			double delta_y	= this.RADIO * Math.sin(theta_l);
			this.PUPIL_L.setLocation(
					this.PUPIL_L_X + delta_x,
					this.PUPIL_L_Y + delta_y);	
		} else {
			double delta_x_l	= RADIO * Math.cos(theta_l);
			double delta_y_l	= RADIO * Math.sin(theta_l);
			PUPIL_L.setLocation(
					this.PUPIL_L_X - delta_x_l,
					this.PUPIL_L_Y - delta_y_l);	
		}
		double Delt_x_r = xm - rx;
		double Delt_y_r = ym - ry;
		double theta_r	= Math.atan(Delt_y_r / Delt_x_r);
		if (Delt_x_r > 0) {
			double delta_x_r	= this.RADIO * Math.cos(theta_r);
			double delta_y_r	= this.RADIO * Math.sin(theta_r);
			this.PUPIL_R.setLocation(
					this.PUPIL_R_X + delta_x_r,
					this.PUPIL_R_Y + delta_y_r);	
		} else {
			double delta_x_r	= RADIO * Math.cos(theta_r);
			double delta_y_r	= RADIO * Math.sin(theta_r);
			PUPIL_R.setLocation(
					PUPIL_R_X - delta_x_r,
					PUPIL_R_Y - delta_y_r);	
		}
	}

}
