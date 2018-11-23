package org.levelup.annotations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PackageClassLoader extends ClassLoader {

    public List<Object> getObjects(String packageName) throws IllegalAccessException, InstantiationException {

        File packageDirectory = new File(packageName.replace('.', '/'));

        List<File> classFiles = findClassFiles(packageDirectory);
        List<Object> objects = new ArrayList<>();
        for (File f : classFiles) {

            try (InputStream inputStream = new FileInputStream(f.getAbsolutePath());
                 ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
                int data = inputStream.read();

                while (data != -1) {
                    buffer.write(data);
                    data = inputStream.read();
                }

                byte[] classData = buffer.toByteArray();

                Class aClass = defineClass(f.getPath().
                                replace("\\", ".").
                                replace(".class", ""),
                        classData, 0, classData.length);

                Object o = aClass.newInstance();
                RandomIntAnnotationProcessor.setField(o);
                objects.add(o);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<File> findClassFiles(File directory) {
        List<File> classFiles = new ArrayList<>();
        if (!directory.exists()) {
            return classFiles;
        }
        File[] files = directory.listFiles();
        if (files == null) return classFiles;
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                classFiles.add(f);
            } else if (f.isDirectory()) {
                classFiles.addAll(findClassFiles(f));
            }
        }
        return classFiles;
    }
}
