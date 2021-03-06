import org.fest.swing.fixture.*
import org.testng.annotations.*
import griffon.application.SingleFrameApplication
import griffon.util.GriffonApplicationHelper

class WordFinderTest {
   private SingleFrameApplication app
   private FrameFixture window

   static {
      SingleFrameApplication.metaClass.shutdown = { ->
         GriffonApplicationHelper.runScriptInsideEDT("Shutdown", delegate)
         delegate.appFrames[0].visible = false
      }
   }

   @BeforeMethod void init() {
      app = new SingleFrameApplication()
      app.bootstrap()
      app.realize()
      window = new FrameFixture( app.appFrames[0] )
      window.show()
   }

   @AfterMethod void cleanup() {
      window.cleanUp()
   }

   // tests

   @Test void assertDefinitionPresent() {
      window.textBox("wordValue").enterText "pugnacious"
      window.button("findWord").click()
      window.label("answer").requireText "Combative in nature; belligerent."
   }

   @Test void assertNoWordPresentInvalidText() {
      window.textBox("wordValue").enterText("")
      window.button("findWord").click()
      window.label("answer")
         .requireText(WordFinderModel.TYPE_A_WORD)
   }

   @Test void assertNoWordPresentUnknownWord() {
      window.textBox("wordValue").enterText("Ha77")
      window.button("findWord").click()
      window.label("answer")
         .requireText(WordFinderModel.UNKNOWN_WORD)
   }
}