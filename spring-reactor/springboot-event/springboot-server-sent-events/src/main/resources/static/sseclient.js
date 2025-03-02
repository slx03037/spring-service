export class SseClient {
    constructor(onMessage) {
        this.onMessage = onMessage;
        this.eventSource = null;
    }

    connect() {
        this.eventSource = new EventSource('http://localhost:8089/events/54321');
        this.eventSource.onmessage = (event) => {
            this.onMessage(event);
        };
        this.eventSource.onerror = (error) => {
            this.disconnect();
        };
    }

    disconnect() {
        if (this.eventSource) {
            this.eventSource.close();
            this.eventSource = null;
        }
    }
}