package com.redeskyller.bukkit.solaryeconomy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configuration {

	private final JavaPlugin plugin;
	private final File file;
	private FileConfiguration config;

	public Configuration(final JavaPlugin plugin, final File file)
	{
		this.file = file;
		this.plugin = plugin;
	}

	public void load()
	{
		try {

			if (!this.file.exists()) {
				this.plugin.getDataFolder().mkdirs();
				this.plugin.saveResource(this.file.getName(), false);
			}

			InputStreamReader inputStream = new InputStreamReader(new FileInputStream(this.file), Charset.forName("UTF-8").name());

			config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public FileConfiguration getConfig()
	{
		return this.config;
	}

	public JavaPlugin getPlugin()
	{
		return this.plugin;
	}

	public File getFile()
	{
		return this.file;
	}
}
