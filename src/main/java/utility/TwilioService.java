package utility;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class TwilioService {

    public String phoneNumber = "4243471461";
    public String countryCode = "+1";

    static String account_id = "ACe87c16897670ea46c8f365c63b00a5e9";
    static String auth_token = "534455780bfaeceaec234ff32d3526a0";

    public TwilioService(){
        Twilio.init(account_id, auth_token);
    }

    public String getOtp(){
        ResourceSet<Message> messages = Message.reader().limit(1).read();

        for (Message record : messages) {
            System.out.println(record.getSid());
            Message message = Message.fetcher(record.getSid()).fetch();
            System.out.println(message.getBody());
            String msg = message.getBody();
            msg = msg.substring(msg.length() - 4);
            return msg;
        }

        return "0000";
    }

}
