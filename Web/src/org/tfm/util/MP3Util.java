package org.tfm.util;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;

public class MP3Util {
    private static final Integer bitRate = 32000;//码率
    private static final Integer samplingRate = 44100;//采样率

    private MP3Util() {
    }

    // 获取时长
    public static int getSeconds(File fmFile) {

        MP3File file;
        try {
            file = new MP3File(fmFile);
            MP3AudioHeader header = (MP3AudioHeader) file.getAudioHeader();
            return getSeconds(header);
        } catch (IOException | InvalidAudioFrameException | ReadOnlyFileException | TagException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getSeconds(MP3AudioHeader header) {
        return header.getTrackLength();
    }

    //压缩
//    public static File compress(String fileName)
//            throws IllegalArgumentException,
//            EncoderException {
//        if (!fileName.endsWith(".mp3")) {
//            //System.out.println("not");
//            return null;
//        }
//        File source = new File(fileName);
//        //System.out.println("file:" + source);
//        String type = fileName.substring(fileName.lastIndexOf("."));
//        String newName = fileName.substring(0, fileName.lastIndexOf("."));
//        File target = new File(newName + "-LQ" + type);
//        //System.out.println("dest:" + target);
//        AudioAttributes audio = new AudioAttributes();
//        audio.setCodec("libmp3lame");
//        audio.setBitRate(bitRate);
//        audio.setChannels(1);
//        audio.setSamplingRate(samplingRate);
//        // VideoAttributes video = new VideoAttributes();
//        // video.setCodec("flv");
//        // video.setBitRate(new Integer(160000));
//        // video.setFrameRate(new Integer(15));
//        // video.setSize(new VideoSize(400, 300));
//        EncodingAttributes attrs = new EncodingAttributes();
//        attrs.setFormat("mp3");
//        attrs.setAudioAttributes(audio);
//        // attrs.setVideoAttributes(video);
//        Encoder encoder = new Encoder();
//            encoder.encode(source, target, attrs);
//        return target;
//    }
/*
    public static void main(String[] args) {
		System.out.println(getSeconds(new File(
				"WebRoot/media/��¼Ƭ֮��_��˪ˮ��_CCTV9��ΰ�������ս���4��-���ٳ���.mp3")));
		// compress("media/02��Ϯ�����.mp3");
	}

	 * //for later public static void getInfo(String fileName) { try { MP3File
	 * file = new MP3File(fileName); MP3AudioHeader header = (MP3AudioHeader)
	 * file.getAudioHeader(); // ���ͷ����Ϣ
	 * System.out.println(header.getSampleRate()); long seconds =
	 * header.getTrackLength(); FMFile fm = new FMFile();
	 * if(file.getID3v2Tag()!=null){ HashMap<String,Object> map =
	 * file.getID3v2Tag().frameMap; String songName =
	 * covertStr(getValueFromMap(map,"TIT2") .toString().trim()); String singer
	 * = covertStr(getValueFromMap(map,"TPE1") .toString().trim()); String
	 * author = covertStr(getValueFromMap(map,"TALB") .toString().trim());
	 * fm.setAuthor(author); au.setSinger(singer); au.setSongName(songName); }
	 * au.setAuthor(""); au.setSinger(""); au.setSongName(fileName.substring(
	 * fileName.lastIndexOf(File.separator)+1,fileName.lastIndexOf(".")));
	 * au.setSeconds(seconds); return au; } catch (Exception e) {
	 * e.printStackTrace(); } return null; } private static Object
	 * getValueFromMap(HashMap<String, Object> map, String string) { Object obj
	 * = map.get(string); return obj == null ? "" : obj; } // ����ת�� gbk�ύ private
	 * static String covertStr(String str) {
	 * 
	 * try { byte[] cs = str.getBytes("ISO8859-1"); String newStr = new
	 * String(cs, "gbk"); if (newStr.indexOf('"') == -1) return null; return
	 * newStr.substring(newStr.indexOf('"') + 1, newStr.lastIndexOf('"')); }
	 * catch (UnsupportedEncodingException e) { e.printStackTrace(); } return
	 * null; } public static AudioInfo getInfo(File file) { return
	 * getInfo(file.getAbsolutePath()); }
	 */
}
