package com.tfbc.tfbctestmod.handlers;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{

    public static Configuration configuration;

    public static void init(File file)
    {
        configuration = new Configuration(file);

        boolean configTestValue = false;

        try
        {
            configuration.load();
            // Read properties from config

            configTestValue = configuration.get("tfbctest", "configTestValue", true, "This is a test config value").getBoolean(true);
        }
        catch (Exception e)
        {
            // Log Exception
        }
        finally
        {
            if(configuration.hasChanged()) {
                configuration.save();
            }
        }

        // System.out.println("ConfigTestValue: " + configTestValue);
    }
}
