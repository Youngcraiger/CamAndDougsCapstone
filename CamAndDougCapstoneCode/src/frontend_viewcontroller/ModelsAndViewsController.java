package frontend_viewcontroller;

import backend_models.*;
import backend_models.TextFile;
import backend_models.EnDecrypter;
import backend_models.CryptoAnalysis;
import backend_models.CharProbability;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;

/**
 * This class is responsible for manipulating the data in the backend, and
 * letting the user otherwise control the GUI on the screen.
 *
 * Responsibilities of this class include:
 *
 * (1) Ask the MainViewDisplay object to change the GUI on the screen in
 * response to user input actions (without modifying any data in the backend).
 *
 * (2) Ask the backend models to modify its data, and also ask the
 * MainViewDisplay object to update the GUI on the screen (to match the data in
 * the backend), in response to user input actions.
 *
 * There should be no code here directly about painting graphics on the screen!
 * That belongs in the MainViewDisplay class.
 *
 * There should also be no code here directly about modeling the problem or
 * situation your program solves.
 *
 * All problem or situation modeling related code must go in the backend classes
 *
 * The FOUR (4) main steps to creating GUI widgets are labeled below. There are
 * many smaller steps you should get familiar with as well.
 *
 * @author cheng
 */
public class ModelsAndViewsController {
    /* Put the following private class into your ModelsAndViewsController class
     * just like the other private classes you wrote for implementing ActionListeners
     *
     * Then in the initController of the ModelsAndViewsController class,
     * assuming you have named the JLabel (that will display the ImageIcon) as picContentPane,
     * add these two lines:
     this.theMainViewDisplay.picContentPane.addMouseMotionListener(new MouseAction());
     this.theMainViewDisplay.picContentPane.addMouseListener(new MouseAction());
     */

    private class MouseAction extends MouseAdapter {
        // You don't need every one of these methods.
        // Choose, keep, and modify only the mouse events you want to handle.
        // Currently, they all just prints a debug string out,
        // and does the mouseGetPoint private helper method.

        @Override
        public void mouseClicked(MouseEvent e) {
            //System.out.print("mouse click");  comment these print statements out - it's for debug only.
            mouseGetPoint(e);
//            for (int i = 0; i < 1000000; i++) {
//                Point p = theBackendModel.thePicFile.getRandomPoint();
//                Color randColor = theBackendModel.thePicFile.getRandomColor();
//                theBackendModel.thePicFile.setColor(p.x + 1, p.y, randColor);
//                theBackendModel.thePicFile.setColor(p.x, p.y + 1, randColor);
//                theBackendModel.thePicFile.setColor(p.x, p.y, randColor);
//                theBackendModel.thePicFile.setColor(p.x + 1, p.y + 1, randColor);
//                theBackendModel.thePicFile.setColor(p.x + 2, p.y + 2, randColor);
//                theBackendModel.thePicFile.setColor(p.x, p.y + 2, randColor);
//                theBackendModel.thePicFile.setColor(p.x + 2, p.y, randColor);
//                theBackendModel.thePicFile.setColor(p.x + 2, p.y + 1, randColor);
//                theBackendModel.thePicFile.setColor(p.x + 1, p.y + 2, randColor);
//
//                theMainViewDisplay.updatePicContentField();
//
//            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
            //System.out.print("mouse press");
            mouseGetPoint(e);

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //System.out.print("mouse release");
            mouseGetPoint(e);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //System.out.print("mouse enter");
            mouseGetPoint(e);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //System.out.print("mouse exit");
            mouseGetPoint(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            //System.out.print("mouse dragged");
            mouseGetPoint(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //System.out.print("mouse moved");
            mouseGetPoint(e);
        }

        private void mouseGetPoint(MouseEvent e) {
            Point p = e.getPoint();
            //System.out.println(" x y: " + p.x + " " + p.y);
        }

        private void paint(MouseEvent e) {
            Point p = e.getPoint();

        }

//        public void randPaint() {
//            for (int i = 0; i < 1000000; i++) {
//                Point p = theBackendModel.thePicFile.getRandomPoint();
//                Color randColor = theBackendModel.thePicFile.getRandomColor();
//                theBackendModel.thePicFile.setColor(p.x + 1, p.y, randColor);
//                theBackendModel.thePicFile.setColor(p.x, p.y + 1, randColor);
//                theBackendModel.thePicFile.setColor(p.x, p.y, randColor);
//                theBackendModel.thePicFile.setColor(p.x + 1, p.y + 1, randColor);
//                theBackendModel.thePicFile.setColor(p.x + 2, p.y + 2, randColor);
//                theBackendModel.thePicFile.setColor(p.x, p.y + 2, randColor);
//                theBackendModel.thePicFile.setColor(p.x + 2, p.y, randColor);
//                theBackendModel.thePicFile.setColor(p.x + 2, p.y + 1, randColor);
//                theBackendModel.thePicFile.setColor(p.x + 1, p.y + 2, randColor);
//
//                theMainViewDisplay.updatePicContentField();
//            }
//        }
    }

    /*
     *
     * ModelsAndViewsController needs to have an instance variable to reference
     * the backend's models because the frontend's ModelsAndViewsController is
     * responsible for asking the backend to modify its data.
     *
     * Since the backend models is initially set up by an instance of the
     * BackendModelSetup class, we just need this one instance variable here:
     */
    BackendModelSetup theBackendModel;
    /*
     *
     * This class also needs to have an instance variable to reference the
     * frontend's MainViewDisplay because the ModelsAndViewsController object is
     * responsible for asking the MainViewDisplay object to update itself.
     */
    MainViewDisplay theMainViewDisplay;

    /*
     *
     * Step 1 of 2 to provide user controls: write user action as private class
     * ------------------------------------------------------------------------
     *
     * User actions are written as private inner classes that implement
     * ActionListener, and override the actionPerformed method.
     *
     * Use the following as a template for writting more user actions.
     */
    private class OpenSourceFileAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String pathToFile = theMainViewDisplay.showOpenDialogue();
            if (pathToFile != null) {
                try {

                    theBackendModel.thePicFile = new PicFile(pathToFile);
                    theMainViewDisplay.updatePicContentField();
                } catch (IOException ex) {
                    Logger.getLogger(ModelsAndViewsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class SaveResultToFileAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String pathToFile = theMainViewDisplay.showSaveDialogue();

            if (pathToFile != null) {
                try {
                    theBackendModel.thePicFile.saveToDisk(pathToFile, "png");
                } catch (IOException ex) {
                    Logger.getLogger(ModelsAndViewsController.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

        }
    }

    private class RandomPaintAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (theBackendModel.thePicFile != null) {
                for (int i = 0; i < (theBackendModel.thePicFile.getHeight() * theBackendModel.thePicFile.getWidth()); i++) {
                    theBackendModel.thePicFile.randPaint();
                    theMainViewDisplay.updatePicContentField();

                }

            }

        }
    }

    private class sorttedPaintAction implements ActionListener {

        int f = 0;

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (theBackendModel.thePicFile != null) {
                for (int i = 0; i < (theBackendModel.thePicFile.getHeight() * theBackendModel.thePicFile.getWidth()); i++) {

                    //System.out.println("sorrtedPaintAction print line 1");
                    Point p = theBackendModel.thePicFile.pixelChooser();
                    //System.out.println("sorrtedPaintAction print line 2");
                    Color c = theBackendModel.thePicFile.getRandomColor();
                    theBackendModel.thePicFile.setColor(p.x + 1, p.y, c);
                    theBackendModel.thePicFile.setColor(p.x, p.y + 1, c);
                    theBackendModel.thePicFile.setColor(p.x, p.y, c);
                    theBackendModel.thePicFile.setColor(p.x + 1, p.y + 1, c);
                    theBackendModel.thePicFile.setColor(p.x + 2, p.y + 2, c);
                    theBackendModel.thePicFile.setColor(p.x, p.y + 2, c);
                    theBackendModel.thePicFile.setColor(p.x + 2, p.y, c);
                    theBackendModel.thePicFile.setColor(p.x + 2, p.y + 1, c);
                    theBackendModel.thePicFile.setColor(p.x + 1, p.y + 2, c);

                    theMainViewDisplay.updatePicContentField();
                    //System.out.println("sorttedPaintAction print line 3");
                    f += 1;
                    System.out.println(f);
                }
                System.out.println("a:" + theBackendModel.thePicFile.a);
                System.out.println("b:" + theBackendModel.thePicFile.b);
            }
        }
    }
//    private class ProbsAction implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//
//            if (theBackendModel.theTextFile == null) {
//                return;
//            }
//
//            CharProbability[] charProbs = CryptoAnalysis.charProbabilitiesOf(theBackendModel.theTextFile.fileContent);
//
//            String charProbStr = " ";
//            for (int x = 0; x < charProbs.length; x++) {
//
//                CharProbability aCharProb = charProbs[x];
//                String aCharProbAsStr = aCharProb.toString();
//                charProbStr = charProbStr + aCharProbAsStr + "\n";
//            }
//
//            theBackendModel.theTextFile.fileContent = charProbStr;
//            theMainViewDisplay.updatePicContentField();
//
//        }
//    }
//    private class SortAction implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//
//            if (theBackendModel.theTextFile == null) {
//                return;
//            }
//
//            CharProbability[] charProbs = CryptoAnalysis.sortedCharProbabilitiesOf(theBackendModel.theTextFile.fileContent);
//
//            String charProbStr = " ";
//            for (int x = 0; x < charProbs.length; x++) {
//
//                CharProbability aCharProb = charProbs[x];
//                String aCharProbAsStr = aCharProb.toString();
//                charProbStr = charProbStr + aCharProbAsStr + (char) 161;
//            }
//
//            theBackendModel.theTextFile.fileContent = charProbStr;
//            theMainViewDisplay.updatePicContentField();
//
//        }
//    }
//    private class DecryptSourceAction implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//
//            if (theBackendModel.theTextFile != null) {
//                theBackendModel.theTextFile.decrypt();
//            }
//            theMainViewDisplay.updatePicContentField();
//        }
//    }
//    private class ApproxDecryptAction implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//            try {
//                String pathToFile = theMainViewDisplay.showOpenDialogue();
//                if (pathToFile == null) {
//                    return;
//                }
//
//                String charListFile = TextFile.readFile(pathToFile);
//                String[] charListArray = charListFile.split("" + (char) 161); //¡
//
//                String extractedList = "";
//                for (int j = 0; j < charListArray.length; j++) {
//                    char extractedChar = charListArray[j].charAt(0);
//                    extractedList = extractedList + extractedChar;
//                }
//
//                String decryptedLetters = CryptoAnalysis.approxDecrypt(theBackendModel.theTextFile.fileContent, extractedList);
//                theBackendModel.theTextFile.fileContent = decryptedLetters;
//                theMainViewDisplay.updatePicContentField();
//            } catch (IOException ex) {
//                Logger.getLogger(ModelsAndViewsController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

    /*
     *
     * Constructor. Probably nothing for students to change.
     */
    public ModelsAndViewsController(BackendModelSetup aBackend, MainViewDisplay aMainViewDisplay) {
        this.theBackendModel = aBackend;
        this.theMainViewDisplay = aMainViewDisplay;
        this.initController();
    }

    /*
     *
     * Step 2 of 2 to provide user controls: wire user action to GUI widgets
     * ----------------------------------------------------------------------
     *
     * Once a private inner class has been written for a user action, you can
     * wire it to a GUI widget (i.e. one of the GUI widgets you created in the
     * MainViewDisplay class and which you gave a memorable variable name!).
     *
     * Use the following as templates for wiring in more user actions.
     */
    private void initController() {

        this.theMainViewDisplay.saveResultToFileButton.addActionListener(new SaveResultToFileAction());
        this.theMainViewDisplay.openSourceFileButton.addActionListener(new OpenSourceFileAction());
        this.theMainViewDisplay.picContentPane.addMouseMotionListener(new MouseAction());
        this.theMainViewDisplay.picContentPane.addMouseListener(new MouseAction());
        this.theMainViewDisplay.startRandPaintButton.addActionListener(new RandomPaintAction());
        this.theMainViewDisplay.sortedArtButton.addActionListener(new sorttedPaintAction());
//        this.theMainViewDisplay.encryptSourceButton.addActionListener(new EncryptSourceAction());
//        this.theMainViewDisplay.decryptSourceButton.addActionListener(new DecryptSourceAction());
//        this.theMainViewDisplay.probsBttn.addActionListener(new ProbsAction());
//        this.theMainViewDisplay.sortBttn.addActionListener(new SortAction());
//        this.theMainViewDisplay.approxDecryptBttn.addActionListener(new ApproxDecryptAction());
    }
}
