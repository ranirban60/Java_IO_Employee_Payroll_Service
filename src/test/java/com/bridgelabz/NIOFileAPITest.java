package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;


public class NIOFileAPITest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {

       //Check File Exists
        Path currentDirPath = Paths.get(HOME);
        Assertions.assertTrue(Files.exists(currentDirPath));

        //Delete File and Check File Not Exists
        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if(Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
        Assertions.assertTrue(Files.notExists(playPath));

        //Create Directory
        Files.createDirectory(playPath);
        Assertions.assertTrue(Files.exists(playPath));

        //Create File
        IntStream.range(1,10).forEach(cntr ->{
            Path tempFile = Paths.get(playPath + "/temp" +cntr);
            Assertions.assertTrue(Files.notExists(tempFile));
            try{
                Files.createFile(tempFile);
            }catch (IOException e){
                Assertions.assertTrue(Files.exists(tempFile));
            }
        });

        //List Files, Directories as well as Files with Extension
        //@Param action a non-interfering actions to perform on the elements
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        //@Param action the action to be performed for each element
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        //@Param action the action to be performed for each element
        Files.newDirectoryStream(playPath, path ->
                path.toFile().isFile() && path.toString().
                startsWith("temp")).forEach(System.out::println);
    }
    @Test
    public void givenADirectoryWhenWatchedListsAllTheActivities() throws IOException{
        Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new Java8WatchServiceExample(dir).processEvents();
    }
}
