package org.tfm.entity;

import java.util.Date;


public class FMFile {
	private Integer id;
	private String file;//文件名
	private String image;//图片名
	private String name;//歌曲名
	private String source;//来源
	private int kind; //分类
	private int seconds;//时长
    private int album;
	private Date uploadDate;
    private int hot;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
    public Date getUploadDate() {
        return uploadDate;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FMFile other = (FMFile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "FMFile{" +
                "id=" + id +
                ", file='" + file + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", kind=" + kind +
                ", seconds=" + seconds +
                ", album=" + album +
                ", uploadDate=" + getUploadDate() +
                '}';
    }
}
