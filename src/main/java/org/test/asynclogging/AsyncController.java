package org.test.asynclogging;

import java.util.concurrent.Callable;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: bherzig
 * Date: 22/09/15
 * Time: 15:41
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AsyncController {

    public static class Message {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(final String value) {
            this.value = value;
        }
    }

    @RequestMapping(value = "/async", method = RequestMethod.GET)
    public Callable<ResponseEntity<Message>> returnMessage() {
        return () -> {
            final Message message = new Message();
            message.setValue("Hello, world!");

            return ResponseEntity.ok(message);
        };
    }

}
