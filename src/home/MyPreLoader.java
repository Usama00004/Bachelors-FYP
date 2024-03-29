//package home;
//
//import home.controllers.LoaderController;
//import javafx.application.Preloader;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//
//public  class MyPreLoader extends Preloader {
//
//    private Stage preloaderStage;
//    private Scene scene;
//
//    public MyPreLoader() {
//        super();
//    }
//
//
//   @Override
//    public  void init() throws Exception{
//
//        Parent root1 = FXMLLoader.load(getClass().getResource("Loader.fxml"));
//        scene = new Scene(root1);
//
//    }
//
//
//    @Override
//    public void start(Stage primaryStage) throws  Exception{
//      this.preloaderStage = primaryStage;
//      preloaderStage.setScene(scene);
//      preloaderStage.initStyle(StageStyle.UNDECORATED);
//      preloaderStage.show();
//    }
//
//    @Override
//    public void handleStateChangeNotification(StateChangeNotification info) {
//
//        StateChangeNotification.Type type = info.getType();
//        switch (type){
//
//            case BEFORE_START:
//                System.out.println("BEFORE START");
//                preloaderStage.hide();
//                break;
//
//
//        }
//
//
//    }
//
//    @Override
//    public void handleApplicationNotification(PreloaderNotification info) {
//
//       if(info instanceof ProgressNotification){
//           LoaderController.label.setText("Loading"+((ProgressNotification) info).getProgress()+"%");
//       }
//
//    }
//
//
//}
