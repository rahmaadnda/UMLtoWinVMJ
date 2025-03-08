package siakreborn.kelasdosen;

import siakreborn.kelasdosen.core.KelasDosen;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class KelasDosenFactory{
    private static final Logger LOGGER = Logger.getLogger(KelasDosenFactory.class.getName());

    public KelasDosenFactory()
    {

    }

    public static KelasDosen createKelasDosen(String fullyQualifiedName, Object ... base)
    {
        KelasDosen record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (KelasDosen) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of KelasDosen.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of KelasDosen.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of KelasDosen.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of KelasDosen.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
