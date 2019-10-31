/*
 * Copyright (c) 2019. AlexandreGiroux
 */

package ca.csf.dfc.persistance;

import javax.swing.filechooser.FileFilter;
import java.io.File;


public class XMLFileFilter extends FileFilter {
	boolean accept = false;

	@Override
	public boolean accept(File p_file) {

		if (p_file.isDirectory()) {
			accept = true;
		} else {
			String ext = extractExtension(p_file);
			if ((ext != null) && ext.equalsIgnoreCase("xml")) {
				accept = true;
			}
		}
		return accept;
	}

	private String extractExtension(File p_file) {
		String fileName = p_file.getName();
		int index = fileName.lastIndexOf(".");

		String extension = null;

		if (index > 0 && index < fileName.length() - 1) {
			extension = fileName.substring(index + 1).toLowerCase();
		}

		return extension;
	}

	@Override
	public String getDescription() {
		return ".xml";
	}
}
