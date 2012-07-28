package org.ihfusa.ticker.sponser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.ItalicAction;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

// Copyright 2012 Google Inc. All Rights Reserved.

/**
 * @author vrboda@google.com (Vamshidhar Reddy Boda)
 * 
 */
public class FilePlayer {

	private static FilePlayer filePlayer;
	public TextTicker frame;
	File selFile;

	private FilePlayer(TextTicker frame) {

		this.frame = frame;

	}

	public static FilePlayer createFilePlayer(TextTicker frame) {

		if (filePlayer == null || filePlayer.frame == frame) {
			filePlayer = new FilePlayer(frame);
		}
		return filePlayer;
	}

	public static FilePlayer getInstance() {
		if (filePlayer == null) {
			throw new RuntimeException(
					"Please create the instance first using a valid JFrame like \"FilePlayer.createFilePlayer(frame);\", which would be appropriate while creating JFrame ");
		}

		return filePlayer;
	}

	public void playFile() {

		String desktopPath = System.getProperty("user.home") + "/Desktop";

		JFileChooser fc = new JFileChooser(new File(desktopPath));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.showOpenDialog(frame);
		selFile = fc.getSelectedFile();
		parseFile(selFile);
	}

	public void resetDisplay() {
		frame.setMainLabelText(TextTicker.MAHA_MANTRA);
	}

	public void parseFile(File file) {

		JsonParser parser = new JsonParser();

		JsonObject sponsersObject;
		try {
			sponsersObject = parser.parse(new FileReader(file))
					.getAsJsonObject().getAsJsonObject("Sponsers");

			JsonArray feastSponsersArrayObject = sponsersObject.get(
					"Todays Feast Sponsers").getAsJsonArray();

			List<String> feastSponsersList = new ArrayList<String>();
			Iterator<JsonElement> iterator = feastSponsersArrayObject
					.iterator();

			while (iterator.hasNext()) {
				String sponser = iterator.next().getAsJsonPrimitive()
						.getAsString();
				System.out.println(sponser);
				feastSponsersList.add(sponser);

			}
			StringBuilder builder = new StringBuilder(feastSponsersList
					.toString().trim());
			builder.replace(builder.lastIndexOf(","),
					builder.lastIndexOf(",") + 1, " and");

			builder.deleteCharAt(0);
			builder.deleteCharAt(builder.length() - 1);
			frame.setMainLabelText(builder.toString());
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							frame,
							"Invalid format! Please check the format. You can check of the file by visiting http://www.jsoneditoronline.org/ or http://jsonlint.com/ \n"
									+ selFile.getName());
			e.printStackTrace();
		}
	}
}
