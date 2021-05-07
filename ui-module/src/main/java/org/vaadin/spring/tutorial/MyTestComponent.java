package org.vaadin.spring.tutorial;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@JsModule("./my-test-component.ts")
@Tag("my-test-component")
public class MyTestComponent extends Component {

    public MyTestComponent() {
    }

    public String getTest() {
        return getElement().getProperty("test");
    }

    public void setTest(String test) {
        getElement().setProperty("test", test);
    }

    @ClientCallable
    private void displayNotification(String text) {
        Notification.show("Notification: " + text);
    }

    public void replaceTestVariable(String newValue){
        getElement().callJsFunction("replaceTestVariable", newValue);
    }

    public Registration addTitleClickListener(ComponentEventListener<MyTestComponentClickEvent> listener) {
        return addListener(MyTestComponentClickEvent.class, listener);
    }

    @DomEvent("title-clicked")
    public static class MyTestComponentClickEvent extends ComponentEvent<MyTestComponent> {

        public MyTestComponentClickEvent(MyTestComponent source, boolean fromClient) {
            super(source, fromClient);

        }
    }
}