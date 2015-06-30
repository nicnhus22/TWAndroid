package com.trainerworkout.trainee.resource.query;

public class URLQueries {

	/**
	 * TODO: Applications settings
	 */
	

	public static final int DATABASE_VERSION = 112;
	
	
	/**
	 * TODO: HTTP Parameters
	 */
	
	public static final int TIME_OUT_CONNECTION = 30000;
	public static final int TIME_OUT_SOCKET = 30000;
	public static final int CHAT_UPDATE_PERIOD = 1000 * 200; // 2 s
	public static final int MESSAGE_UPDATE_PERIOD = 1000 * 500 ; // 5 s
	
	/**
	 * TODO: Google Notification Configuration
	 * Tag used on log messages
	 */
  
/**	public static final String SENDER_ID = "249203049517";
 
	public static final String TAG = "AndroidHive GCM";
 
	public static final String DISPLAY_MESSAGE_ACTION = "com.androidhive.pushnotifications.DISPLAY_MESSAGE";
 
	public static final String EXTRA_NOTIFICATION_TYPE = "Type";
	public static final String EXTRA_NOTIFICATION_COUNT = "Count";
	public static final String EXTRA_NOTIFICATION_MESSAGE = "Message";
	
	public static final int MAX_ATTEMPTS = 5;
	
	public static final int BACKOFF_MILLI_SECONDS = 2000;

 */
	/**
	 * TODO: Host
	 */
	//public static final String HOST = "beta.tagyourlife.com";
	//public static final String HOST = "tagyourlife.com";
	//public static final String HOST = "tagyourlife.kintu.it";
	public static final String HOST = "staging.trainerworkout.com";
	public static final String ImageHost = String.format("http://%s/",HOST);
	
	/**
	 * TODO: Install directory
	 */
	//public static final String INSTALL_DIR = "tagyourlife/";
	//public static final String INSTALL_DIR = "";
	public static final String REST_API = "API";
	
	
	/**
	 * TODO: Server Zone
	 */	
	public static final String SERVER_ZONE = String.format("http://%s/", HOST) + REST_API;
	
	
	/**
	 * TODO: AUTH service
	 */	
	public static final String GET_AUTH_TOKEN_QUERY = String.format("https://%s/session", SERVER_ZONE);
	
	
	/* Olf Api keys 
	public static String LINKEDIN_CONSUMER_KEY = "dfhh85x55u7r";
	public static String LINKEDIN_CONSUMER_SECRET = "BwVJ3zu2QKAUybFx";*/
	
	public static String LINKEDIN_CONSUMER_KEY = "75blp2i84taz4p";
	public static String LINKEDIN_CONSUMER_SECRET = "4o8dAhtH1qkB52v9";

	public static String OAUTH_CALLBACK_SCHEME = "x-oauthflow-linkedin";
	public static String OAUTH_CALLBACK_HOST = "callback";
	public static String OAUTH_CALLBACK_URL = OAUTH_CALLBACK_SCHEME + "://" + OAUTH_CALLBACK_HOST;

		
	/**
	 * TODO: USER service
	 */	
	public static final String GET_USER_BY_EXTERNAL_ID_QUERY = String.format("http://%s/user", SERVER_ZONE) + "%s";
	
	public static final String WORKOUTS_USER_QUERY = String.format("http://%s/Workouts", SERVER_ZONE);

	public static final String CREATE_USER_QUERY = String.format("http://%s/user/", SERVER_ZONE);
	
	public static final String EDIT_USER_QUERY = String.format("http://%s/Users/Profile", SERVER_ZONE);
	
	public static final String LOGIN_AUTO = String.format("http://%s/Users/LoginAuto", SERVER_ZONE);
	
	public static final String LOGIN_USER_QUERY = String.format("http://%s/Users/Login", SERVER_ZONE);
	
	public static final String SINGUP_USER_QUERY = String.format("http://%s/Users/Register", SERVER_ZONE);



	
//	/**
//	 * TODO: QUESTION service
//	 */
//	public static final String GET_QUESTION_BY_EXTERNAL_ID_QUERY = String.format("http://%s/question", SERVER_ZONE) + "%s";
//
//	public static final String CREATE_QUESTION_QUERY = String.format("http://%s/question/", SERVER_ZONE);
//
//	public static final String EDIT_QUESTION_QUERY = String.format("http://%s/question", SERVER_ZONE) + "%s";
//
//	public static final String REMOVE_QUESTION_QUERY = String.format("http://%s/question", SERVER_ZONE) + "%s";
//
//
//	/**
//	 * TODO: ANSWER service
//	 */
//	public static final String CREATE_ANSWER_QUERY = String.format("http://%s/answer", SERVER_ZONE);
//
//	public static final String EDIT_ANSWER_QUERY = String.format("http://%s/answer", SERVER_ZONE) + "%s";
//
//
//	/**
//	 * TODO: MESSAGE service
//	 */
//	public static final String GET_MESSAGE_BY_EXTERNAL_ID_QUERY = String.format("http://%s/message", SERVER_ZONE) + "%s";
//
//	public static final String CREATE_MESSAGE_QUERY = String.format("http://%s/message", SERVER_ZONE);
//
//	public static final String EDIT_MESSAGE_QUERY = String.format("http://%s/message", SERVER_ZONE)  + "%s";
//
//	public static final String REMOVE_MESSAGE_QUERY = String.format("http://%s/message", SERVER_ZONE)  + "%s";
//
//
//	/**
//	 * TODO: INTEREST service
//	 */
//	public static final String GET_INTEREST_BY_EXTERNAL_ID_QUERY = String.format("http://%s/interest?id=", SERVER_ZONE) + "%s";
//
//	public static final String LIST_INTEREST_QUERY = String.format("http://%s/interest?ToDo=", SERVER_ZONE) + "%s";
//
//	public static final String SEARCH_INTEREST_QUERY = String.format("http://%s/interest", SERVER_ZONE);
//
//	public static final String CREATE_INTEREST_QUERY = String.format("http://%s/interest", SERVER_ZONE);
//
//
//	/**
//	 * TODO: IMAGE Service
//	 */
//	public static final String PROFILE_IMAGE_LOCATION = String.format("http://%s/", HOST) + INSTALL_DIR + "website/var/assets/images/profile/" + "%s";
//
//	public static final String CREATE_IMAGE_QUERY = String.format("http://%s/profileimage/", SERVER_ZONE);
//
//	public static final String UPLOAD_IMAGE_LOCATION = String.format("http://%s/", HOST) + INSTALL_DIR + "website/var/assets/images/" + "%s";
//
//	public static final String GET_USER_IMAGES_BY_EXTERNAL_ID = String.format("http://%s/assets/", SERVER_ZONE) + "%s";
//
//	public static final String UPLOAD_IMAGES_QUERY = String.format("http://%s/assets/", SERVER_ZONE);
//
//
//	/**
//	 * TODO: NOTIFICATION Service
//	 */
//	public static final String GET_NOTIFICATION_BY_EXTERNAL_ID_QUERY = String.format("http://%s/notifications", SERVER_ZONE) + "%s";
//
//	public static final String CREATE_NOTIFICATION_QUERY = String.format("http://%s/notifications/", SERVER_ZONE);
//
//	public static final String REMOVE_NOTIFICATION_QUERY = String.format("http://%s/notifications", SERVER_ZONE)  + "%s";
//
//	//==================================================================================================================================
//	/**
//	 * TODO: CONNECTIONS Servcie
//	 */
//	public static final String GET_CONNECTIONS_BY_EXTERNAL_ID_QUERY = String.format("http://%s/connection", SERVER_ZONE) + "%s";
//
//
//	/**
//	 * TODO: CONTENT Service
//	 */
//	public static final String GET_CONTENT_BY_EXTERNAL_ID_QUERY = String.format("http://%s/content", SERVER_ZONE) + "%s";
//
//	public static final String CREATE_CONTENT_QUERY = String.format("http://%s/content", SERVER_ZONE);
//
//	public static final String EDIT_CONTENT_QUERY = String.format("http://%s/content?id=", SERVER_ZONE) + "%s";
//
//	/**
//	 * TODO: ASSETS Service
//	 */
//	public static final String GET_ASSETS_BY_EXTERNAL_ID_QUERY = String.format("http://%s/assets", SERVER_ZONE) + "%s";
//
//
//	/**
//	 * TODO: COUNTRY Service
//	 */
//	public static final String GET_COUNTRY_BY_EXTERNAL_ID_QUERY = String.format("http://%s/country", SERVER_ZONE) + "%s";
//
//
//	/**
//	 * TODO: FEEDBACK Service
//	 */
//	public static final String CREATE_FEEDBACK_QUERY = String.format("http://%s/feedback/", SERVER_ZONE);
//
//	public static final String REMOVE_FEEDBACK_QUERY = String.format("http://%s/feedback?id=", SERVER_ZONE) + "%s";
//
//	/**
//	 * TODO: LOCATION Service
//	 */
//	public static final String GET_LOCATION_BY_EXTERNAL_ID_QUERY = String.format("http://%s/location", SERVER_ZONE) + "%s";
//
//	public static final String CREATE_LOCATION_QUERY = String.format("http://%s/location/", SERVER_ZONE);
//
//
//	/**
//	 * TODO: REQUEST Service
//	 */
//	public static final String GET_REQUEST_BY_EXTERNAL_ID_QUERY = String.format("http://%s/request", SERVER_ZONE) + "%s";
//
//	public static final String CREATE_REQUEST_QUERY = String.format("http://%s/request/", SERVER_ZONE);
//
//	public static final String EDIT_REQUEST_QUERY = String.format("http://%s/request", SERVER_ZONE) + "%s";
//
//
//	/**
//	 * TODO: CONTENT MANAGE Service
//	 */
//	public static final String GET_CONTENTMANAGE_BY_EXTERNAL_ID_QUERY = String.format("http://%s/contentmanage?id=", SERVER_ZONE) + "%s";
//
//	public static final String REMOVE_CONTENTMANAGE_QUERY = String.format("http://%s/contentmanage?id=", SERVER_ZONE) + "%s";
//
//
//	/**
//	 * TODO: SETTINGS Service
//	 */
//	public static final String GET_SETTINGS_BY_EXTERNAL_ID_QUERY = String.format("http://%s/settings?id=", SERVER_ZONE) + "%s";
//
//	public static final String CREATE_SETTINGS_QUERY = String.format("http://%s/settings", SERVER_ZONE);
//
//	public static final String EDIT_SETTINGS_QUERY = String.format("http://%s/settings?id=", SERVER_ZONE)  + "%s";
//
//	public static final String DELETE_SETTINGS_QUERY = String.format("http://%s/settings?id=", SERVER_ZONE)  + "%s";
//
//	/**
//	 * TODO: SOCIAL Service(Facebook,Twitter)
//	 */
//	public static final String GET_SOCIAL_BY_EXTERNAL_ID_QUERY = String.format("http://%s/social", SERVER_ZONE) + "%s";
//
//	public static final String CREATE_SOCIAL_QUERY = String.format("http://%s/social/", SERVER_ZONE);
//
//
//	/**
//	 * TODO: STORE
//	 */
//	public static final String PRODUCT_IMAGE_LOCATION = String.format("http://%s/", HOST) + INSTALL_DIR + "website/var/assets/images/products/" + "%s";
//
//	public static final String GET_STORE_BY_EXTERNAL_ID_QUERY = String.format("http://%s/store", SERVER_ZONE) + "%s";
//
//	public static final String CREATE_STORE_QUERY = String.format("http://%s/store", SERVER_ZONE);
//
//	/**
//	 * TODO: ADVERTISE
//	 */
//	public static final String ADVERTISE_IMAGE_LOCATION = String.format("http://%s/", HOST) + INSTALL_DIR + "website/var/assets/images/advertise/" + "%s";
//
//	public static final String CREATE_ADVERTISE_QUERY = String.format("http://%s/advertise", SERVER_ZONE);
//
//	public static final String GET_ADVERTISE_BY_EXTERNAL_ID_QUERY = String.format("http://%s/advertise", SERVER_ZONE) + "%s";
//
//	public static final String DELETE_ADVERTISE_QUERY = String.format("http://%s/advertise?id=", SERVER_ZONE)  + "%s";
//
	/**
	 *  TODO: Constant
	 */
	public static final String LOGIN_PREFERENCE = "LOGIN";
	public static final String LOGOUT_PREFERENCE = "LOGOUT";
	public static final String DIALOG_PREFERENCE = "DIALOG";

	public static final int MENU_NEWS = 0;
	public static final int MENU_PHOTO = 1;
	public static final int MENU_QUESTION = 2;
	
	public static final int MENU_SEARCH = 3;
	public static final int MENU_ADD_CONNECTION = 4;
	
	public static final int MENU_WRITE_MESSAGE = 5;
	public static final int MENU_INBOX = 6;		
	
	public static final int MENU_ADD_INTEREST = 7;
	public static final int MENU_INTEREST = 8;
	public static final int MENU_SEEALL = 9;
	public static final int MENU_GURU =10;
	
	public static final int MENU_DASHBORD= 11;	
	public static final int MENU_SETTING = 12;
	public static final int MENU_INFO = 13;
	public static final int MENU_LOGOUT = 14;
	
	public static final int MENU_STORECART = 15;
	
	//TODO: Types of queries. They must match queries above 	
	public static enum QBQueryType{
		
		// AUTH
		QBQueryTypeGetAuthToken,
		
		// USERS service
		QBQueryGetUserByExternalID,
		QBQueryCreateUser,
		QBQueryEditUser,
		QBQueryLoginAuto,
		QBQueryLoginUser,
		QBQuerySignupUser,
		QBQueryWorkouts,
		QBQueryLogoutUser,
		QBQueryUpdatePassword,
		QBQueryGetUserInfoByExternalID,
		QBQueryGetUserSuggestions,
		QBQueryGetUserSearch,
		QBQueryRemoveUserInfo,
		
		// QUESTION service
		QBQueryGetQuestion,
		QBQueryCreateQuestion,
		QBQueryEditQuestion,
		QBQueryRemoveQuestion,
	
		// ANSWER service
		QBQueryCreateAnswer,
		QBQueryEditAnswer,
		
		//MESSAGE service
		QBQueryGetMessageByExternalID,
		QBQueryGetRecivedMessageByExternalID,
		QBQueryGetNextMessageByExternalID,
		QBQueryCreateMessage,
		QBQueryEditMessage,
		QBQueryRemoveMessage,
				
		// INTEREST service
		QBQueryGetInterestByExternalID,
		QBQueryListInterest,
		QBQueryCreateInterest,
		QBQueryListFamousInterest,
		
		// IMAGES Services
		QBQueryProfileImageLocation,
		QBQueryUploadImageLocation,
		QBQueryGetUserImagesByExternalId,
		
		// NOTIFICATION Service
		QBQueryGetNotificationsByExternalID,
		QBQueryCreateNotification,
		QBQueryRemoveNotification,
		
		// CONTENT Service
		QBQueryGetContentByExternalID,
		QBQueryCreateContent,
		QBQueryEditContent,
		QBQueryPostComment,
		QBQueryBlockContent,
		
		// CONNECTION Service
		QBQueryGetConnectionByExternalID,
		
		// REQUEST Service
		QBQueryGetRequestByExternalID,
		QBQueryCreateRequest,
		QBQueryEditRequest,
		
		// FEEDBACK Service
		QBQueryCreateFeedback,
		QBQueryRemoveFeedback,
		
		//Location Service
		QBQueryGetLocationByExternalID,
		QBQueryCreateLocation,
		
		//CONTENT MANAGE Service
		QBQueryGetContentManageByExternalID,
		QBQueryRemoveContentManage,
		
		//MESSAGE service
		QBQueryGetSettingsByExternalID,
		QBQueryCreateSettings,
		QBQueryEditSettings,
		QBQueryRemoveSettings,
		
		//SOCIAL Service
		QBQueryGetSocialByExternalID,
		QBQueryCreateSocial,
		
		//STORE Service
		QBQueryGetStoreByExternalID,
		QBQueryGetStoreInfoByExternalID,
		QBQueryCreateStore,
		
		//COUNTRY service
		QBQueryGetCountries,
		QBQueryGetStatesByExternalID,
		
		QBQueryCreateAdvertise,
		QBQueryGetAdvertiseByExternalID,
		QBQueryRemoveAdvertise,
	}
	
	
}