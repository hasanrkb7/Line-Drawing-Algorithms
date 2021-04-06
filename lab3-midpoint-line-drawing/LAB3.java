import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;


public class LAB3 implements GLEventListener{
	 
     private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
	   GL2 gl = drawable.getGL().getGL2();

	 //ID-18201139
	    
	   //for digit 3
	   MPA(gl, -30,40,10,40);
       MPA(gl, 5,-5,10,40);
       MPA(gl, -35,-5,5,-5);
       MPA(gl, 0,-50,5,-5);
       MPA(gl, -35,-50,-2,-50);
       
       
       //for digit 9
       MPA(gl, 35,-5,45,40);
       MPA(gl, 35,-5,65,-5);
       MPA(gl, 45,40,70,40);
       MPA(gl, 55,-50,70,40);
       MPA(gl, 30,-50,55,-50);   
   }
   
   
   @Override
   public void init(GLAutoDrawable gld) {
       GL2 gl = gld.getGL().getGL2();
       glu = new GLU();

       gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
       gl.glViewport(-100, -50, 50, 100);
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
       glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
   }
   
   

	    public void MPA(GL2 gl, int x0, int y0, int x1, int y1) {
	        int zone = findZone(x0, y0, x1, y1);
	        if (zone == 0)
	            drawLine0(gl, x0, y0, x1, y1, 0);
	        else {
	        	ConvertZone0(gl, x0, y0, x1, y1, zone);
	        }
	    }

	    private int findZone(int x0, int y0, int x1, int y1) {
	        int dx = x1 - x0, dy = y1 - y0;
	        if (Math.abs(dx) >= Math.abs(dy)) { //for detecting zone 0, 3, 4, 7
	            if (dy >= 0 && dx >= 0)
	                return 0;
	            else if (dx < 0 && dy >= 0)
	                return 3;
	            else if (dx < 0 && dy < 0)
	                return 4;
	            else return 7;
	        } 
	        else {                           //for detecting zone 1, 2, 5, 6
	            if (dy >= 0 && dx >= 0)
	                return 1;
	            else if (dx < 0 && dy >= 0)
	                return 2;
	            else if (dx < 0 && dy < 0)
	                return 5;
	            else return 6;
	        }
	    }
	    
	    private void ConvertZone0(GL2 gl, int x0, int y0, int x1, int y1, int zone) {
	    	if (zone == 1) {
	    		int a = y0;
	    		int b = x0;
	    		int c = y1;
	    		int d = x1;
	    		
	    		drawLine1(gl, a, b, c, d, 1);
	    	}
	    	else if (zone == 2) {
	    		int a = y0;
	    		int b = x0;
	    		int c = y1;
	    		int d = x1;
	    		
	    		drawLine1(gl, a, b, c, d, 2);
	    	}
	    	else if (zone == 3) {
	    		int a = -x0;
	    		int b = y0;
	    		int c = x1;
	    		int d = y1;
	    		
	    		drawLine1(gl, a, b, c, d, 3);
	    	}
	    	else if (zone == 4) {
	    		int a = -x0;
	    		int b = -y0;
	    		int c = -x1;
	    		int d = -y1;
	    		
	    		drawLine1(gl, a, b, c, d, 4);
	    	}
	    	else if (zone == 5) {
	    		int a = -y0;
	    		int b = -x0;
	    		int c = -y1;
	    		int d = -x1;
	    		
	    		drawLine1(gl, a, b, c, d, 5);
	    	}
	    	else if (zone == 6) {
	    		int a = -y0;
	    		int b = x0;
	    		int c = -y1;
	    		int d = x1;
	    		
	    		drawLine1(gl, a, b, c, d, 6);
	    	}
	    	else if (zone == 7) {
	    		int a = x0;
	    		int b = -y0;
	    		int c = x1;
	    		int d = -y1;
	    		
	    		drawLine1(gl, a, b, c, d, 7);
	    	}
	    }
	    
	    public void ConvertOriginal(GL2 gl, int x0, int y0, int zone) {
	    	if (zone == 1) {
	    		int x = y0;
	    		int y = x0;
	    		
	    		gl.glVertex2f(x, y);
	    	}
	    	else if (zone == 2) {
	    		int x = -y0;
	    		int y = x0;
	    		
	    		gl.glVertex2f(x, y);
	    	}
	    	else if (zone == 3) {
	    		int x = -x0;
	    		int y = y0;
	    	
	    		gl.glVertex2f(x, y);
	    	}
	    	else if (zone == 4) {
	    		int x = -x0;
	    		int y = -y0;
	    	
	    		gl.glVertex2f(x, y);
	    	}
	    	else if (zone == 5) {
	    		int x = -y0;
	    		int y = -x0;

	    		gl.glVertex2f(x, y);
	    	}
	    	else if (zone == 6) {
	    		int x = y0;
	    		int y = x0;

	    		gl.glVertex2f(x, y);
	    	}
	    	else if (zone == 7) {
	    		int x = x0;
	    		int y = -y0;
	
	    		gl.glVertex2f(x, y);
	    	}
	    }
	    
	    

	    private void drawLine0(GL2 gl, int x0, int y0, int x1, int y1, int zone) {
	        float dx = x1 - x0, dy = y1 - y0;
	        float dE = dy;
	        float dNE = (dy - dx);
	        float d = (dy) - dx;
	        float x = x0, y = y0;

	        gl.glPointSize(3.0f);
	        gl.glColor3d(1, 0, 0);
	        gl.glBegin(GL2.GL_POINTS);
	        gl.glVertex2f(x, y);

	        while (x <= x1) {
	            if (d < 0) {
	                x++;
	                d = d + dE;

	            } 
	            else {
	                x++;
	                y++;
	                d = d + dNE;
	            }
	            gl.glVertex2f(x, y);
	        }
	        gl.glEnd();
	    }

	    public void drawLine1(GL2 gl, int x0, int y0, float x1, int y1, int zone) {
	    	float dx = x1 - x0, dy = y1 - y0;
	        float dE = dy;
	        float dNE = (dy - dx);
	        float d = (dy) - dx;
	        int x = x0, y = y0;

	        gl.glPointSize(3.0f);
	        gl.glColor3d(1, 0, 0);
	        gl.glBegin(GL2.GL_POINTS);
	        

	        while (x <= x1) {
	        	ConvertOriginal(gl, x, y, zone);
	        	x++;
	            if (d > 0) {
	                y++;
	                d = d + dNE;

	            } 
	            else {
	                d = d + dE;
	            }
	        }
	        gl.glEnd();
	    }

	    
       

   @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }
   
   @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   
     
   public static void main(String[] args) {
      //getting the capabilities object of GL2 profile
	   final GLProfile profile = GLProfile.get(GLProfile.GL2);
       GLCapabilities capabilities = new GLCapabilities(profile);
       // The canvas
       final GLCanvas glcanvas = new GLCanvas(capabilities);
       LAB3 b = new LAB3();
       glcanvas.addGLEventListener(b);
       glcanvas.setSize(400, 400);
       //creating frame
       final JFrame frame = new JFrame("Mid Point Algorithm");
       //adding canvas to frame
       frame.add(glcanvas);
       frame.setSize(640, 480);
       frame.setVisible(true);
   }//end of main
}//end of classimport javax.media.opengl.GL2;