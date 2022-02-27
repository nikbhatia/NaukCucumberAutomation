package com.naukri.automation.util;


import java.util.*;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.Assert;
import com.naukri.test.base.BaseAutomation;

public class ReadEmail extends BaseAutomation {
	public String DetectAttachmentInMail(String SubjectLine, String UserEmail, String UserPassword, String FolderName) {
		boolean Flag = false;
		boolean mailPresent = false;
		String AttachmentDetails = null;
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect("imap.gmail.com", UserEmail, UserPassword);
			Folder selectedFolder = store.getFolder(FolderName);
			selectedFolder.open(Folder.READ_WRITE);
			for (int msgindex = selectedFolder.getMessageCount(); msgindex >= 0; msgindex--) {
				if (selectedFolder.getMessage(msgindex).getSubject().equals(SubjectLine)) {
					mailPresent = true;
					selectedFolder.getMessage(msgindex).setFlag(Flags.Flag.SEEN, true);
					Multipart multiPart = (Multipart) selectedFolder.getMessage(msgindex).getContent();
					int numberOfParts = multiPart.getCount();
					for (int partCount = 0; partCount < numberOfParts; partCount++) {
						MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
						if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
							Flag = true;
							AttachmentDetails = part.getFileName();
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		if (mailPresent == true) {
			if (Flag == true)
				return AttachmentDetails;
			else
				return ("No attachment in the mail");
		} else
			return ("mail not found");
	}

	public void WaitandReadEmailContent1(String SubjectLine, String UserEmail, String UserPassword, String FolderName,
			String StorageFileLocation) {
		WriteToFile writeToFile = new WriteToFile();
		boolean mailPresent = false;
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect("imap.gmail.com", UserEmail, UserPassword);
			Folder selectedFolder = store.getFolder(FolderName);
			selectedFolder.open(Folder.READ_WRITE);

			int msgindex = selectedFolder.getMessageCount();
			System.out.println(selectedFolder.getMessage(msgindex).getReceivedDate());
			for (msgindex = selectedFolder.getMessageCount(); (msgindex / 2) > 0; msgindex--) {
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(selectedFolder.getMessage(msgindex).getReceivedDate());
//				System.out.println(selectedFolder.getMessage(msgindex).getReceivedDate());
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(new Date());
				System.out.println(new Date());
				boolean diff = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
						&& cal2.get(Calendar.DAY_OF_YEAR) - cal1.get(Calendar.DAY_OF_YEAR) == 0
						&& cal2.get(Calendar.HOUR_OF_DAY) - cal1.get(Calendar.HOUR_OF_DAY) < 1;

//				System.out.println(selectedFolder.getMessage(msgindex).getSubject());
				for (int j = 0; (!selectedFolder.getMessage(msgindex).getSubject().equals(SubjectLine) || j > 20);) //
					if (selectedFolder.getMessage(msgindex).getSubject().equals(SubjectLine) && //
							diff) {
//						System.out.println("waiting for the last " + j + " seconds");
						Thread.sleep(1000);
						j++;
						if (j == 20) {
							Assert.fail("mail not found"); //
							break;
						}
						mailPresent = true;
						selectedFolder.getMessage(msgindex).setFlag(Flags.Flag.SEEN, true);
						Message msg = selectedFolder.getMessage(msgindex);
						Object content = msg.getContent();
						if (content instanceof String) { // System.out.println(content.toString());
							writeToFile.writeText(content.toString(), StorageFileLocation);
							break;
						}

						if (msg.isMimeType("text/plain")) {
							System.out.println("text/plain");
						} else if (msg.isMimeType("multipart/*")) {
							System.out.println("multipart/*");
						} else if (msg.isMimeType("message/rfc822")) {
							System.out.println("message/rfc822");
						} else {
							System.out.println("Other");
						}

						if (content instanceof Multipart) {
							Multipart mp = (Multipart) content;
							for (int i = 0; i < mp.getCount(); i++) {
								BodyPart bp = mp.getBodyPart(i);
								if (Pattern.compile(Pattern.quote("text/html"), Pattern.CASE_INSENSITIVE)
										.matcher(bp.getContentType()).find()) {
									writeToFile.writeText((String) bp.getContent(), StorageFileLocation);
								}
							}
						}
						break;
					}
			}
		} catch (Exception mex) {
			mex.printStackTrace();
		}
		if (mailPresent == false) {
			writeToFile.writeText("mail not found", StorageFileLocation);
			Assert.fail("Mail Not found");
		}
	}

	public static String[] WaitandReadEmailContent(String SubjectLine, String UserEmail, String UserPassword, String FolderName,
			String StorageFileLocation) {
		String[] str=new String[2];
		WriteToFile writeToFile = new WriteToFile();
		boolean mailPresent = false;
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect("imap.gmail.com", UserEmail, UserPassword);
			Folder selectedFolder = store.getFolder(FolderName);
			selectedFolder.open(Folder.READ_WRITE);
			int msgindex = selectedFolder.getMessageCount();
			for(int j=0;j<10;j++)
			{
			if(msgindex==0) {
				TestNGLogUtility.info("Number of mails: "+ msgindex + " Waiting for mail");
				wait.hardWait(10);
				msgindex = selectedFolder.getMessageCount();
			}
			else {
				String gMailSub = selectedFolder.getMessage(msgindex).getSubject();
				if(gMailSub.contains("     ")) {
					gMailSub = gMailSub.replace("     ", " ");
				}
				TestNGLogUtility.info("Number of mails: "+ msgindex);
				TestNGLogUtility.info(selectedFolder.getMessage(msgindex).getReceivedDate().toString());
				TestNGLogUtility.info("Gmail sub: "+gMailSub);
				TestNGLogUtility.info("Actual sub: "+ SubjectLine);
			for (msgindex = selectedFolder.getMessageCount(); (msgindex) > 0; msgindex--) {
				//System.out.println(selectedFolder.getMessage(msgindex).getSubject());

				if (gMailSub.contains(SubjectLine)) {
					mailPresent = true;
					selectedFolder.getMessage(msgindex).setFlag(Flags.Flag.SEEN, true);
					Message msg = selectedFolder.getMessage(msgindex);
					Object content = msg.getContent();
					if (content instanceof String) {
						//str[1]=content.toString();
						str[1]=content.toString();
						writeToFile.writeText(content.toString(), StorageFileLocation);
						break;
					}

					if (msg.isMimeType("text/plain")) {
						System.out.println("text/plain");
					} else if (msg.isMimeType("multipart/*")) {
						System.out.println("multipart/*");
					} else if (msg.isMimeType("message/rfc822")) {
						System.out.println("message/rfc822");
					} else {
						System.out.println("Other");
					}

					if (content instanceof Multipart) {
						Multipart mp = (Multipart) content;
						for (int i = 0; i < mp.getCount(); i++) {
							BodyPart bp = mp.getBodyPart(i);
							if (Pattern.compile(Pattern.quote("text/html"), Pattern.CASE_INSENSITIVE)
									.matcher(bp.getContentType()).find()) {
								str[1]=(String) bp.getContent();
								writeToFile.writeText((String) bp.getContent(), StorageFileLocation);
							}
						}
					}
					break;
				}
			}
			break;
			}
			}

				
		} catch (Exception mex) {
			mex.printStackTrace();
		}
		if (mailPresent == false) {
			writeToFile.writeText("mail not found", StorageFileLocation);
			// Assert.fail("Mail Not found");
			str[0]="Mail Not Found";
			return str;
		} else {
			str[0]="Mail Found";
			return str;
		}
	}

	public static String ReadEmailContent(String SubjectLine, String UserEmail, String UserPassword, String FolderName,
			String StorageFileLocation) {
		WriteToFile writeToFile = new WriteToFile();
		boolean mailPresent = false;
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect("imap.gmail.com", UserEmail, UserPassword);
			Folder selectedFolder = store.getFolder(FolderName);
			selectedFolder.open(Folder.READ_WRITE);
			for (int msgindex = selectedFolder.getMessageCount(); msgindex >= 0; msgindex--) {
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(selectedFolder.getMessage(msgindex).getReceivedDate());
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(new Date());
				boolean diff = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
						&& cal2.get(Calendar.DAY_OF_YEAR) - cal1.get(Calendar.DAY_OF_YEAR) == 1;
				if (selectedFolder.getMessage(msgindex).getSubject().contains(SubjectLine))
				// if(selectedFolder.getMessage(msgindex).getSubject().equals(SubjectLine) &&
				// diff)
				{
					mailPresent = true;
					selectedFolder.getMessage(msgindex).setFlag(Flags.Flag.SEEN, true);
					Message msg = selectedFolder.getMessage(msgindex);
					Object content = msg.getContent();
					if (content instanceof String) {
//						System.out.println(content.toString());
						writeToFile.writeText(content.toString(), StorageFileLocation);
					}
					/*
					 * if (msg.isMimeType("text/plain")) { System.out.println("text/plain"); } else
					 * if (msg.isMimeType("multipart/*")) { System.out.println("multipart/*"); }
					 * else if (msg.isMimeType("message/rfc822")) {
					 * System.out.println("message/rfc822"); } else { System.out.println("Other"); }
					 */
					if (content instanceof Multipart) {
						Multipart mp = (Multipart) content;
						for (int i = 0; i < mp.getCount()-1; i++) {
							BodyPart bp = mp.getBodyPart(i);
							if (Pattern.compile(Pattern.quote("text/html"), Pattern.CASE_INSENSITIVE)
									.matcher(bp.getContentType()).find()) {
								writeToFile.writeText((String) bp.getContent(), StorageFileLocation);
							}
						}
					}
					break;
				}
			}
		} catch (Exception mex) {
			mex.printStackTrace();
		}
		if (mailPresent == false) {
			writeToFile.writeText("mail not found", StorageFileLocation);
			// Assert.fail("Mail Not found");
			return "Mail Not Found";
		} else {
			return "Mail Found";
		}
	}

	public String get_SenderAddress(String SubjectLine, String UserEmail, String UserPassword, String FolderName) {
		String SenderAdd = null;
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect("imap.gmail.com", UserEmail, UserPassword);
			Folder selectedFolder = store.getFolder(FolderName);
			selectedFolder.open(Folder.READ_ONLY);
			for (int msgindex = selectedFolder.getMessageCount(); msgindex > 0; msgindex--) {
				if (selectedFolder.getMessage(msgindex).getSubject().equals(SubjectLine)) {
					Message msg = selectedFolder.getMessage(msgindex);
					Address[] in = msg.getFrom();
					for (Address address : in) {
						SenderAdd = (address.toString());
					}
					break;
				}
			}
		} catch (Exception mex) {
			mex.printStackTrace();
		}
		return SenderAdd;
	}

	/*
	 * Function name :- deleteMail 
	 * Functionality : Below function will empty the inbox
	 */

	public static void deleteMail(String UserEmail, String UserPassword, String FolderName) {
		TestNGLogUtility.info("Deleting mails with label "+FolderName);
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect("imap.gmail.com", UserEmail, UserPassword);
			Folder selectedFolder = store.getFolder(FolderName);
			selectedFolder.open(Folder.READ_WRITE);
			
			Message[] arrayMessages = selectedFolder.getMessages();

			
//			System.out.println(arrayMessages.length);
			for (int i = 0; i < arrayMessages.length; i++) {
				Message message = arrayMessages[i];
				String subject = message.getSubject();
				message.setFlag(Flags.Flag.DELETED, true);
//				System.out.println("Marked DELETE for message: " + subject);

			}

		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}
	
	
	public static void  sendMail(String pathOfAttachment, String fileName) throws EmailException {
		  System.out.println("===Test for Sending CommonsEmail started===");  
	        // Create the attachment
	        EmailAttachment attachment = new EmailAttachment();
	        attachment.setPath(pathOfAttachment);
	        attachment.setDisposition(EmailAttachment.ATTACHMENT);
	        attachment.setDescription("Resume of rj");
	        attachment.setName(fileName);
	        // Create the email message
	        MultiPartEmail email = new MultiPartEmail();
	        email.setHostName("smtp.gmail.com");
	        email.setSmtpPort(465);
	        email.setAuthenticator(new DefaultAuthenticator("assementtestingqa@gmail.com", "Test@123"));
	        email.setSSLOnConnect(true);
	        email.setFrom("assementtestingqa@gmail.com");
	        email.setSubject("vendorportalnaukri Test");
	        email.setMsg("vendorportalnaukri test mail ... :-)");
	        email.addTo("assementtestingqa@gmail.com");
	        // add the attachment
	        email.attach(attachment);
	        // send the email
	        email.send();
	        System.out.println("===Test for Sending CommonsEmail ended===");
	}
	
}
