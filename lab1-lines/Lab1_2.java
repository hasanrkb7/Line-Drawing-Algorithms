import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab1_2 implements GLEventListener{

static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);
   
   public static void main(String[] args) {
     //getting the capabilities object of GL2 profile
   
     
     Line l = new Line();
     //creating frame
     glcanvas.addGLEventListener(l);
     glcanvas.setSize(600, 400);
     
     final JFrame frame = new JFrame ("straight Line");
     //adding canvas to frame
     frame.getContentPane().add(glcanvas);
     frame.setSize(frame.getContentPane().getPreferredSize());
     frame.setVisible(true);
     
  }
   public void display(GLAutoDrawable drawable) {
         try {
         final GL2 gl = drawable.getGL().getGL2();
           gl.glBegin (GL2.GL_POINTS);//static field
           File myFile = new File ("coordinates.txt");
           Scanner sc = new Scanner (myFile);
           double x_val,y_val;
           while(sc.hasNextLine())
           {
           x_val = Double.parseDouble(sc.nextLine());
           y_val = Double.parseDouble(sc.nextLine());
           gl.glVertex2d(x_val, y_val);
           }
           gl.glEnd();
         }
         catch (Exception e)
         {
         System.out.println(e);
         }
         
     
   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
  //4. drive the display() in a loop
   }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;