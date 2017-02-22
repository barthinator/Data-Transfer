import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;

public class CopyMachineFrame extends JFrame {

	private JPanel contentPane;
	private String source = "";
	private String dest = "/Volumes/BACKUP/";
	private String backupPath = "/Volumes/BACKUP/";
	private static String password = "n/a";
	private JTextField textField;
	private String folderName;
	
	private JProgressBar progressBar = new JProgressBar();
	private JTextPane transferInfo = new JTextPane();
	private JScrollPane jsp = new JScrollPane();
	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		
		String[] connect = { "osascript", "-e", "mount volume \"afp://192.168.8.154\" as user name \"imtstusrv\" with password" + "\"" + "\"" };
		
		try {
			Runtime.getRuntime().exec(connect);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyMachineFrame frame = new CopyMachineFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CopyMachineFrame() {
		
		
		JScrollPane scrollPane = new JScrollPane();
        JScrollPane scrollPane_1 = new JScrollPane();
        
        JButton Run = new JButton("Run");
        
        Run.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  // this makes sure the button you are pressing is the button variable
                  if(e.getSource() == Run) {
                	 
                	 folderName = textField.getText();
                	 dest = dest + folderName;
                     new File(backupPath + folderName + "").mkdirs();
                     run(source, dest);
                   }
            }
          });
        
        JLabel lblSourcedragFolder = new JLabel("Source (Drag Folder Here)");
        
        JLabel lblDestinationkittServer = new JLabel("Destination (KITT Server)");
        
        textField = new JTextField();
        textField.setColumns(10);
        
        JLabel lblFolderName = new JLabel("Folder Name (Ticket No. Last Name)");
        
        
        JLabel lblFileTransferInfo = new JLabel("File Transfer Info");
        
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        
        //jsp.createVerticalScrollBar();
        jsp.setViewportView(transferInfo);
        transferInfo.setEditable(false);
        
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblSourcedragFolder)
        			.addContainerGap(225, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(5)
        			.addComponent(lblDestinationkittServer, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(226, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        			.addGap(14))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblFolderName)
        			.addContainerGap(159, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(textField, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        			.addGap(159))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblFileTransferInfo)
        			.addContainerGap(278, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(transferInfo, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        			.addGap(7))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(88)
        			.addComponent(Run, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        			.addGap(102))
        );
     
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(13)
        			.addComponent(lblSourcedragFolder)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(17)
        			.addComponent(lblDestinationkittServer)
        			.addGap(8)
        			.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblFolderName)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblFileTransferInfo)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(transferInfo, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(Run)
        			.addGap(12))
        );
		
		JTextArea text = new JTextArea();
		JTextArea text1 = new JTextArea();
		
		text.setEditable(false);
		
		scrollPane.setViewportView(text);
		scrollPane_1.setViewportView(text1);
		   
            new FileDrop( System.out, text, /*dragBorder,*/ new FileDrop.Listener()
            {   public void filesDropped(java.io.File[] files)
                {   for( int i = 0; i < files.length; i++ )
                    {   try
                        {   
                    	source = files[i].getCanonicalPath();
                    	text.append(files[i].getCanonicalPath() + "\n" );
                    	System.out.println(files[i].length() + "HEEERERERERERR");
                        }   // end try
                        catch( java.io.IOException e ) {}
                    }   // end for: through each dropped file
                }   // end filesDropped
            }); // end FileDrop.Listener
            
            
            
            //THE DESTINATION BACKUP SERVER FOR VISUAL PURPOSES ONLY
            text1.append(dest);
    		text1.setEditable(false);
            getContentPane().setLayout(groupLayout);
            
		
           setBounds(100, 100, 391, 445);
           setDefaultCloseOperation(EXIT_ON_CLOSE );
           setVisible(true);
	}
	
    public void run(String source, String dest)
    {
    	File srcFolder = new File(source);
    	File destFolder = new File(dest);

    	//make sure source exists
    	if(!srcFolder.exists()){
           System.out.println("Directory does not exist.");
           //just exit
           System.exit(0);
        }else{

           try{
        	copyFolder(srcFolder,destFolder);
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }

    	System.out.println("Done");
    }
	
	public void copyFolder(File src, File destination)
	    	throws IOException{

	    	if(src.isDirectory()){

	    		//if directory not exists, create it
	    		if(!destination.exists()){
	    		   destination.mkdir();
	    		   System.out.println("Directory copied from "
	                              + src + "  to " + destination);
	    		}

	    		//list all the directory contents
	    		String files[] = src.list();

	    		String s = "";
	    		
	    		int fileCount = 0;
	    		for (String file : files) {
	    		   //construct the src and dest file structure
	    		   File srcFile = new File(src, file);
	    		   File destFile = new File(destination, file);
	    		   //recursive copy
	    		   System.out.println("File count" + fileCount++);
	    		   System.out.println((int)(((double)fileCount / (double)files.length) * 100));
	    		   String progress = (int)(((double)fileCount / (double)files.length) * 100) + "";
	    		   s += progress + "% finished, " + fileCount + " successfully transfered" + "\r";
	    		   transferInfo.setText(s);
	    		   progressBar.setValue((int)(((double)fileCount / (double)files.length) * 100));
	    		   copyFolder(srcFile,destFile);
	    		}

	    	}else{
	    		//if file, then copy it
	    		//Use bytes stream to support all file types
	    		InputStream in = new FileInputStream(src);
	    	        OutputStream out = new FileOutputStream(destination);

	    	        byte[] buffer = new byte[1024];

	    	        int length;
	    	        //copy the file content in bytes
	    	        while ((length = in.read(buffer)) > 0){
	    	    	   out.write(buffer, 0, length);
	    	        }

	    	        in.close();
	    	        out.close();
	    	        System.out.println("File copied from " + src + " to " + destination);
	    	}
	    }
}
