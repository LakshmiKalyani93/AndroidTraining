package com.pcs.lazyloaderdemo;

import java.io.File;

import android.content.Context;

public class FileStore {
	private File directory;
	public FileStore(Context context){
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
		{
			//if SDCARD is mounted (SDCARD is present on device and mounted)
			directory = new File(
					android.os.Environment.getExternalStorageDirectory(),"LazyList");
		}
		else
		{
			// if checking on simulator the create cache directory in your application context
			directory=context.getCacheDir();
		}

		if(!directory.exists()){
			// create cache directory in your application context
			directory.mkdirs();
		}
	}
	public File	getFile(String url){
		String fileName=String.valueOf(url.hashCode());
		File file= new File(directory,fileName);	
		return file;
	}
	public void clear(){
		 File[] files=directory.listFiles();
	        if(files==null)
	            return;
	        //delete all cache directory files
	        for(File file:files)
	            file.delete();
		
	}
}
