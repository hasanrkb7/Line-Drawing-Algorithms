import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;

public class LAB4 implements GLEventListener{
   
 private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      
      //Last digit = 3
      CA(gl, 0,10,0,0);
      CA(gl, 0,30,0,20);
      CA(gl, 0,50,0,40);
      CA(gl, 0,70,0,60);
      CA(gl, 0,-10,0,-20);
      CA(gl, 0,-30,0,-40);
      CA(gl, 0,-50,0,-60);
      
      CA(gl, -20,70,-20,60);
      CA(gl, -40,70,-40,60);
      CA(gl, -60,70,-60,60);
     
      CA(gl, -20,10,-20,0);
      CA(gl, -40,10,-40,0);
      CA(gl, -60,10,-60,0);
      
      CA(gl, -20,-50,-20,-60);
      CA(gl, -40,-50,-40,-60);
      CA(gl, -60,-50,-60,-60);
     
      
      
   }
   @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
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

   

   @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   
   
public void CA(GL2 gl, int x0, int y0, int x1, int y1) {
       
       gl.glPointSize(3.0f);
       gl.glColor3d(1, 0, 0);
       gl.glBegin (GL2.GL_POINTS);
       
       
        int x = 0;
        int y;
        
        if(y0 > y1) {
            y = y0- y1;
        }
        else {
         y= Math.abs(y1)- Math.abs(y0);
        }
        
        int d = 1 - y;
        int dx = x0;
        int dy = y0 - y;
        
        
        while (x < y) {
               if (d < 0) {
               
                //choose E
                d = d + 2*(x) + 3;
                x++;
   
              }
               //Choose SE
               else {
                d = d + 2*(x-y) + 5;
                x++;
                y--;
               
               }
             
             Drawpoints(gl, x, y, dx, dy); 
    
        }
       
        gl.glEnd();
    }

   public void Drawpoints(GL2 gl, int x, int y, int dx, int dy) {
	   
	   gl.glVertex2d(x+ dx, y+ dy);
       gl.glVertex2d(y+ dx, x+ dy);
       gl.glVertex2d(y+ dx, -x+ dy);
       gl.glVertex2d(x+ dx, -y+dy);
       
       gl.glVertex2d(-x+ dx, y+ dy);
       gl.glVertex2d(-y+ dx, x+ dy);
       gl.glVertex2d(-y+ dx, -x+ dy);
       gl.glVertex2d(-x+ dx, -y+ dy);

   }

   
   
   
   
   
   public static void main(String[] args) {
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
      // The canvas 
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      LAB4 l = new LAB4();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(400, 400);
      //creating frame
      final JFrame frame = new JFrame ("Midpoint Circle Algorithm");
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
   }//end of main
}//end of classimport javax.media.opengl.GL2;
