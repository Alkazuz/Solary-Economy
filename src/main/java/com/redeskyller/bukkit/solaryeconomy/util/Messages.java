package com.redeskyller.bukkit.solaryeconomy.util;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class Messages {

	private Configuration config;
	private JavaPlugin plugin;

	public Messages(JavaPlugin plugin)
	{
		this.plugin = plugin;
	}

	public Messages load()
	{
		this.config = new Configuration(this.plugin, new File(this.plugin.getDataFolder(), "mensagens.yml"));
		this.config.load();
		return this;
	}

	public String get(String string)
	{
		string = string.toUpperCase();
		return this.config.getConfig().getString(string).replace("&", "§");
	}

}
