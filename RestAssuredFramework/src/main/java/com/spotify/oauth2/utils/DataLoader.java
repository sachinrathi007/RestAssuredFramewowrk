


package com.spotify.oauth2.utils;

import java.util.Properties;

/*Singleton Design pattern*/
public class DataLoader {

	private static final String GET_PLAYLIST_ID = "get_playlist_id";
	private static final String UPDATE_PLAYLIST_ID = "update_playlist_id";

	private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources/";
	private Properties properties;
	private static DataLoader dataLoader;

	private DataLoader() {
		properties = PropertyUtils.propertyLoader(RESOURCES_PATH + "data.properties");
	}

	public static DataLoader getInstance() {
		if (dataLoader == null) {
			dataLoader = new DataLoader();
		}
		return dataLoader;
	}

	public String get_GetPlaylistID() {
		String prop = properties.getProperty(GET_PLAYLIST_ID);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException(
					"Property " + GET_PLAYLIST_ID + " is not specified in the data.properties file");
		}
	}

	public String get_UpdatePlaylistID() {
		String prop = properties.getProperty(UPDATE_PLAYLIST_ID);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException(
					"Property " + UPDATE_PLAYLIST_ID + " is not specified in the data.properties file");
		}
	}
}