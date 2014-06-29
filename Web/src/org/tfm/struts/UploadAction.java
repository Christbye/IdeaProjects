package org.tfm.struts;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tfm.entity.FMFile;
import org.tfm.util.BCSUtil;

import java.io.File;
import java.util.List;
@Controller("upload")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UploadAction extends FileBaseActionSupport {

	private FMFile fm;
	private List<File> files;

	private List<String> filesFileName;
    private File file;

	private List<String> filesContentType;
    private String json;

    public String getJson() {
        return json;
    }


	public void setFm(FMFile fm) {
		this.fm = fm;
	}

    public FMFile getFm() {
        return fm;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void setFilesFileName(List<String> filesFileName) {
        this.filesFileName = filesFileName;
    }

    public void setFilesContentType(List<String> filesContentType) {
        this.filesContentType = filesContentType;
    }


    public String execute() throws Exception {
		// 从temp－dir写出start
//		String media = ServletActionContext.getServletContext().getRealPath(
//				"/media");
//		String image = ServletActionContext.getServletContext().getRealPath(
//				"/image");
		//System.out.println(media);
		//System.out.println(image);
       // System.out.println(files.size());
//        System.out.println(fm);
			for (int i = 0; i < files.size(); i++) {
				//System.out.println("file:"+file.get(i));
				//System.out.println("fileName:"+fileFileName.get(i));
				//System.out.println("contentType:"+filesContentType.get(i));
                //System.out.println("fileName:"+filesFileName.get(i));
                //InputStream is = new FileInputStream(files.get(i));
				String dir;
				String name = filesFileName.get(i);
                File tmp = files.get(i);
                boolean flag = tmp.renameTo(new File(tmp.getParent(), filesFileName.get(i)));
                if(!flag){
                    throw new RuntimeException("can not rename file");
                }
//				System.out.println(name.substring(name.lastIndexOf(".")));
				if(!".mp3".equalsIgnoreCase(name.substring(name.lastIndexOf(".")))||filesContentType.get(i).contains("image")){
					dir = "/image";
					fm.setImage(name);
				}else{
					dir = "/media";
					fm.setFile(name);
                    file = tmp;
				}
                BCSUtil.putObjectByFile(tmp,dir);
//				OutputStream os = new FileOutputStream(new File(dir,
//						filesFileName.get(i)));
//				//1k cache
//				byte[] buffer = new byte[1024];
//				int length ;
//				while ((length = is.read(buffer)) != -1 ) {
//					os.write(buffer,0,length);
//				}
//				//System.out.println("end");
//				os.close();
//				is.close();
			}
			//System.out.println(fm);
		//从temp-dir写出end
		
            System.out.println("exe start");
            //包含压缩
			json = ""+service.save(fm,file);
            System.out.println("exe end");
        return "json";
	}
}
