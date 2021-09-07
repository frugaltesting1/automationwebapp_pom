package utility;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class TwilioService {

    public String phoneNumber = "4234543317";
    public String countryCode = "+1";

    static String account_id = "AC181687959fbda305475b4dcf57867b78";
    static String auth_token = "27e147c87ebc9b7590ff2c89257075a6";

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
