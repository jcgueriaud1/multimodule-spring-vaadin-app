import {css, customElement, html, LitElement, property} from 'lit-element';

interface MyTestComponentServerInterface {
    displayNotification(text: string): void;
}

@customElement('my-test-component')
export class MyTestComponent extends LitElement {

    static get styles() {
        return css`
        :host {
            display: block;
        }
        `;
    }

    private $server?: MyTestComponentServerInterface;

    @property({ attribute: true })
    private test: String = "test";

    private clickAction() {
        this.$server!.displayNotification("Click on button");
    }

    private titleClickedEvent() {
        this.dispatchEvent(new CustomEvent('title-clicked', {
            // you can add detail: {kicked: true},
            cancelable: true
        }));
    }

    public replaceTestVariable(newValue: string) {
        this.test = newValue;
    }
    /**
     * Main method of the component
     *
     */
    render() {
        return html`<div>Test attribute ${this.test}</div>
        <div @click=${this.titleClickedEvent}>Title</div>
                    <div><button @click=${this.clickAction}>Call Notification</button></div>
        `;
    }

}