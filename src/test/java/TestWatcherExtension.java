import com.google.gson.JsonArray;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestWatcherExtension implements TestWatcher, BeforeEachCallback {
    private List<Path> listOfVideosFiles = new ArrayList<>();
    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        listOfVideosFiles= Files.walk(Paths.get("videos/")).filter(Files::isRegularFile ).collect(Collectors.toList());

    }

 @Override
   public void testSuccessful(ExtensionContext context){
   deleteTraces(context);
    deleteVideos();
 }

private void deleteTraces (ExtensionContext context){

    Path tracepath=  Paths.get("traces/"+ context.getDisplayName().replace("()", "")+ ".zip" );
    try {
        Files.deleteIfExists(tracepath);
    } catch (IOException e) {
        System.out.println("Failed to delete trace file with name " + tracepath.getFileName());
    }
 }

 private void deleteVideos  () {
        try {
     List<Path> newVideos = Files.walk(Paths.get("videos/")).filter(Files::isRegularFile).filter(el -> !listOfVideosFiles.contains(el)).collect(Collectors.toList());

        for (Path path: newVideos){
            Files.deleteIfExists(path);
        }
        } catch (IOException e ){
            System.out.println("Failed to delete videos. Error message was  "+ e.getMessage());
        }

    }

 }


