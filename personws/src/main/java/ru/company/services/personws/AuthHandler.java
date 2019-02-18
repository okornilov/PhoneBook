package ru.company.services.personws;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.company.services.personws.entity.UserSession;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AuthHandler implements SOAPHandler<SOAPMessageContext> {
    public Set<QName> getHeaders() {
        return null;
    }

    public boolean handleMessage(SOAPMessageContext context) {
        try {
            Map<String, Object> headers = (Map<String, Object>) context.get(MessageContext.HTTP_REQUEST_HEADERS);
            List<Object> tokenList = (List<Object>) headers.get("token");
            String token = null;
            if (tokenList != null && tokenList.size() != 0){
                token = (String) tokenList.get(0);
            }

            if (token == null){
                failAuth(context, "User token is null");
            }

            Session session = DBSessionFactory.getSession();
            try {

                Query query = session.createNamedQuery("CheckToken");
                query.setParameter("token", token);
                UserSession userSession = (UserSession) query.uniqueResult();

                if (userSession == null){
                    failAuth(context, "invalid user token");
                }
            } finally {
                session.close();
            }
        } catch (SOAPException e) {
            System.err.println(e);
        }

        return true;
    }

    private void failAuth(SOAPMessageContext context, String msg) throws SOAPException {
        SOAPMessage soapMsg = context.getMessage();
        SOAPBody soapBody = soapMsg.getSOAPPart().getEnvelope().getBody();
        SOAPFault soapFault = soapBody.addFault();
        soapFault.setFaultCode("403");
        soapFault.setFaultString(msg);
        throw new SOAPFaultException(soapFault);
    }

    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    public void close(MessageContext context) {

    }
}
