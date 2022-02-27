package com.naukri.pageobjects.Requirements;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.WaitUtility;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.mk_latn.No;
import io.cucumber.datatable.DataTable;

/**
 * Requirement Creation page object
 * 
 * @author rachit.mehrotra
 *
 */
public class RequirementCreationPagePO extends PageObjectWrapper {
	// class variables
	public static Map<Object, Object> requirementDetails = new HashMap<Object, Object>();
	String jobDescriptionText = "Job Description";
	String candidateDetail = "Candidate Details";
	String otherSalaryDetailsText = "Other Salary Details";
	String companyName = "companyName";
	String aboutCompany = "aboutCompany";

	public static String requirementName;
	public static String requirementOverviewPageURL = null;
	boolean flag=false;

	By requirementTitle = By.id("projectName");
	By jobTitle = By.id("title");
	By jobDescription = By.id("description_editor");
	By fillCandidateDetails = By.id("fill_Canddetails");
	By candidateDetailsEditor = By.id("candidateProfile_editor");
	By salaryCurrency = By.id("salaryCurrency");
	By rupeesLocator = By.xpath("//option[contains(@value,\"Rupees\")]");
	By usdLocator = By.xpath("//option[contains(@value,\"U.S Dollars\")]");
	By minSalary = By.id("minSalary");
	By maxSalary = By.id("maxSalary");
	By showSalaryToJobSeeker = By.xpath("//input[contains(@name,\"showSalary\")]");
	By enterMoreSalaryDetails = By.id("fill_othersalary");
	By otherSalaryDetails = By.id("otherSalary_editor");
	By minExp = By.id("minExp");
	By maxExp = By.id("maxExp");
	By keywords = By.id("keywordDiv");
	By keywordsLabel = By.xpath("//label[@for=\"Keywords\"]");
	By jobLoctaions = By.id("inp_cityIds");
	By removeKeyword = By.id("tagRemove");
	By internationalJobLocations = By.id("inp_internationalLocation");
	By groupOrHiringFor = By.id("inp_hiringFordd");
	By visibilityDD = By.xpath("//select[contains(@id,\"visToMe\")]");
	By sendNotificationMailCheckbox = By.id("sendNotificationMail");
	By recruiterName = By.id("inp_selListAndAddBtn");
	By hiringManagerDD = By.id("selectHm");
	By vacancyCheck = By.id("fill_vacancies");
	By vacancyField = By.id("vacancies");
	By addReferenceCode = By.id("fill_referencecode");
	By addReferenceCodeField = By.id("referenceNo");
	By addRequirementBtn = By.id("buttonID");
	By locationDD = By.id("inp_cityIds");
	By jobLocatorOption = By.xpath("(//ul[@id=\"ul_cityIds\"]//a[text()='${cityName}'])[1]");
	By internationalLocationCheckbox = By.id("fillIntrLoc");
	By internationalLocationDD = By.id("inp_internationalLocation");
	By internationalJobLocation = By.xpath("//ul[@id = \"ul_internationalLocation\"]//a[text()='${location}']");
	By locationsClear = By.id("clearId_cityIds");
	By otherCountryIdSelector = By.id("otherCountry");
	By otherCountrySaveOrCancel = By.xpath("//div[@id=\"otherCountryDiv\"]//a[text()='${textOption}']");
	By keywordEditor = By.xpath("//input[contains(@id,'keyword')]");
	By jobPostType = By.id("NaukriPostingType");
	By checkboxOfJobType = By.xpath("//select[@id=\"NaukriPostingType\"]/preceding::label//span");
	By gradSelectRadioButton = By.xpath("//label[text() = \" Any Graduation\"]/input");
	By csJobCheckbox = By.xpath("(//p[text()=\"  Post on Career Site  \"]/following-sibling::span)[1]");
	By degreeSelector = By.xpath(
			"//label[contains(text(),'${degreeStandard}')]/following-sibling::div//label[text()='${optionOfDegree}']");
	By ppgSelectector = By.xpath(
			"//label[contains(text(),'${degreeStandard}')]/following-sibling::div//span[text()='${optionOfDegree}']/input");
	By ugCourseSelector = By.xpath("//ul[@id=\"ul_ugLeft\"]//a[text()='${ugCourse}']");
	By ugCourseSpecialization = By.xpath("//ul[@id=\"ul_ugRight\"]//a[text()='${specialization}']");
	By ugCourseSpecializationTag = By.xpath("//ul[@id=\"eduRefineUG\"]//span");
	By pgCourseSpecializationTag = By.xpath("//ul[@id=\"eduRefinePG\"]//span");
	By ppgCourseSpecializationTag = By.xpath("//ul[@id=\"eduRefinePPG\"]//span");
	By pgCourseSelector = By.xpath("//ul[@id=\"ul_pgLeft\"]//a[text()='${ugCourse}']");
	By ppgCourseSelector = By.xpath("//ul[@id=\"ul_ppgLeft\"]//a[text()='${ugCourse}']");
	By pgCourseSpecialization = By.xpath("//ul[@id=\"ul_pgRight\"]//a[text()='${specialization}']");
	By ppgCourseSpecialization = By.xpath("//ul[@id=\"ul_ppgRight\"]//a[text()='${specialization}']");
	By optionOfUgAndPgRelation = By.xpath("//p[contains(text(),'${replacementRelation}')]");
	By ppgSelector = By.xpath("//label[@for=\"Doctorate\"]/following-sibling::div//span[text()='${replacementText}']");
	By industryDD = By.id("inp_industrydd");
	By functionalArea = By.id("inp_fareadd");
	By jobRole = By.id("inp_froledd");
	By saveRequirement = By.id("saveProject");
	By questionnaireLightBoxTitle = By.xpath("//p[text()='${text}']");
	By skipQuestionnaireNowButton = By.id("skip_AutoQuestionaire");
	By requirementPlaceholderOnOverview = By.xpath("//span[contains(text(),'Requirement:')]");
	By requirementNamePlaceHolder = By.xpath("//div[contains(text(),' ${requirementName} ')]");
	By industrySugg = By.xpath("(//ul[@id='ul_industrydd']//li[contains(@class,'pickVal')])[1]/a");
	By functionalSugg = By.xpath("(//ul[@id='ul_fareadd']//li[contains(@class,'pickVal')])[1]/a");
	By jobRoleSugg = By.xpath("(//ul[@id='ul_froledd']//li[contains(@class,'pickVal')])[1]/a");
	By companyName_txt = By.id("companyName");
	By aboutCompany_txt = By.id("aboutCompanyDesc");
	By activeJobOrRequirementTab = By.id("tab1");
	By eleprojectNameErrorMessage = By.id("projectName_err");
	By elejobTitleErrorMessage = By.id("title_err");
	By eleMinSalaryErrorMessage = By.id("salary_err");
	By eleMaxSalaryErrorMessage = By.id("salary_err_max");
	By eleMinWorkExperienceErrorMessage = By.id("experience_err");
	By eleMaxWorkExperienceErrorMessage = By.id("experience_err_max");
	By eleKeywordErrorMessage = By.id("tagValArr_err");
	By eleLocationErrorMessage = By.id("cityIds_err");
	By eleAboutCompanyLabel = By.xpath("//label[contains(text(),\"About Company\")]");
	By eleAboutCompanyErrorMessage = By.id("aboutCompanyDesc_err");
	By eleIndustryLabel = By.xpath("//label[contains(text(),\"Industry\")]");
	By eleIndustryErrorMessage = By.id("industry_err");
	By eleFunctionalAreaErrorMessage = By.id("functionalArea_err");
	By eleGroupSuggestorSelector = By.xpath("//a[contains(@id,\"hiringFordd\")]");
	By eleProcessOverlay = By.xpath("//div[contains(@class, \"processing-overlay processing-overlay-40  \")]");
	By eleKeywordValue = By.xpath("//ul[@id='tagContainer']//li[@class[contains(.,'tagList')]]");
	By eleJobLocations = By.xpath("//ul[@class='refinItms']//li");
	By ddQuestionnaire = By.xpath("//input[@id='inp_questionnairedd']");
	By eleQuestionnaireList = By.xpath("//div[@id='dp_questionnairedd']//li");
	By eleSelectedQuestionnaire = By.xpath("(//div[@id='dp_questionnairedd']//li/a)[${Questionnaire}]");
	By aboutCompany_iframe = By.id("aboutCompany_editor");
	By eleOtherSalaryNonMigrated = By.id("otherSalary");
	By elePreviewOnReqPage = By.id("previewProject");
	By eleSubmitPreviewOnReqPage = By.id("submitPreview");
	
	
	
	By eleNoVariableText = By.id("noVariableSlryTxt");
	By linkVariableChange = By.xpath("//span[@id='noVariableSlryTxt']/*[text()='Change']");
	By eleVeriableTextField = By.id("variableSalaryPercentage");
	By eleVariableFieldText = By.xpath("//input[@id='variableSalaryPercentage']/preceding-sibling::label");
	By eleVariableFieldMandatoryStarIcon = By.xpath("//label[text()='Variable CTC Percentage: ']/span[text()='*']");
	By eleTextAgainstVariableField = By.xpath("//input[@id='variableSalaryPercentage']/following-sibling::span");
	By eleVariableFieldOnPreviewPage = By.xpath("//*[contains(text(),'Variable CTC Percentage')]");
	By eleVariableFieldValueOnPreviewPage = By
			.xpath("//*[contains(text(),'Variable CTC Percentage')]/following-sibling::p");
	By eleVariableFieldValueOnRequirementDetailsPage = By.xpath("//*[contains(text(),'Variable CTC Percentage')]/..");
	By eleStarIconOnKeywordChip = By
			.xpath("//span[contains(@class,'tagit-label') and text()='${value}']/preceding-sibling::a");
	By eleRequirementName = By.xpath("(//a[contains(text(),'${value}')])[1]");
	By eleRemoveAllTag = By.id("tagRemove");
	By eleTextUnderKeywordField = By.xpath("//em[@class='info']");
	By eleKeywordFieldOnPreview = By.xpath("//span[@class='proSubtext']");
	By eleStarOnKeywordPreview = By
			.xpath("//*[@class='tabLIBlue' and contains(.,'${value}')]/span[@class='keySkillFullStar']");
	By eleKeywordOnPreview = By.xpath("//*[@class='tabLIBlue' and contains(.,'${value}')]");
	By linkContactDetails = By.xpath("//label[contains(text(),'${value}')]/parent::div//a[text()='${value}']");
	By eleNaukriRecruiterProfileField = By.xpath("//input[@id='attachRecProfileEmail']");
	By eleContactMandatoryFields = By.xpath("//label[contains(text(),'${value}')]");
	By eleContactMandatoryField = By.xpath("(//label[contains(text(),'${value}')])[${value}]");
	By keywordProject = By.xpath("//input[@id='keywordProject']");
	By eleShowSalarytoJobSeeker = By.xpath("//input[@name='showSalary']");
	By elePhotosList = By.xpath("//ul[@id='ul_photoIds']//a");
	By eleSelectedPhotos = By.xpath("(//ul[@id='ul_photoIds']//a)[${value}]");
	By eleSelectedPhotosTitle = By.xpath("(//ul[@id='ul_photoIds']//li)[${value}]");
	By elePhotosCountOnPreview = By.xpath("//div[@class='media mediaSize']");
	By eleSelectedPhotosOnPreview = By.xpath("(//div[@class='media mediaSize'])[${value}]");
	By elePhotosViewOnPreview = By.xpath("(//div[@class='media mediaSize'])[${value}]//div[contains(text(),'View')]");
	By elePhotoPreview = By.id("photoShowId");
	By elePhotoPreviewCloseIcon = By.id("closeViewPhotoBtn");
	By elePhotoDD = By.id("inp_photoIds");
	By eleAddress = By.id("addressDDHV");
	By eleAddressCL = By.id("addressDDCL");
	By eleEducationDoctorateOption = By
			.xpath("(//div[contains(@class,'eduWrap')]//span[contains(.,'${value}')][1]/input)");
	By eleEducationgradicationOption = By
			.xpath("(//div[contains(@class,'eduWrap')]//label[contains(.,'${value}')][1]/input)");
	By eleEducationCourse = By.xpath("//div[@id='${value}Left']//a[text()='${value}']");
	By eleEducationSubject = By.xpath("//div[@id='${value}Right']//a[text()='${value}']");
	By confirmationPopup = By.xpath("//p[text()='Select Graduation Not Required?']");
	By confirmationPopupText = By.xpath("//div[@class='l_share_cont cle']");
	By eleContinueBtn = By.id("ContinueEducationSwitch");
	By eleDegree = By.xpath("//label[contains(text(),'${value}')]/parent::div");
	By eleEducationSpecializations = By.xpath("(//ul[@id='relationChangeBtns']//span)[${value}]");
	By eleEducationSpecializationsInput = By.xpath("(//ul[@id='relationChangeBtns']//input)[${value}]");
	By eleDefaultEducationSpecializations = By.xpath("//div[@id='specializationRelationSummary']//span");
	By eleCancelLinkOnContinuePopup = By.id("cancelEducationSwitch");
	By eleCloseLinkOnContinuePopup = By.id("closeSwitchEducationBtn");
	By eleWalkinStartDate = By.id("walkinStartDate");
	By eleWalkinStartDateMadatory = By.xpath("//label[contains(text(),'Walk-in Start Date')]/span[contains(text(),'*')]");
	By eleWalkinStartDateError = By.id("walkinEndDate_err");
	By eleWalkinStartDateCalendar = By.xpath("//a[@rel='calenContWalkin1']");
	By eleWalkinStartDateNextCalendarDate = By.xpath("(//td[@class='currDate']/following-sibling::td)[1]");
	By eleWalkinStartDateNextCalendarDate2 = By.xpath("(//td[@class='currDate']/parent::tr/following-sibling::tr/td)[1]");
	By eleWalkinStartDatePreviousCalendarDate = By.xpath("(//td[@class='currDate']/preceding-sibling::td)[2]");
	By eleWalkinStartDatePreviousCalendarDateTotal = By.xpath("(//td[@class='currDate']/parent::tr/td)");
	By eleWalkinStartDatePreviousCalendarDate2 = By.xpath("(//td[@class='currDate']/parent::tr/td)[${value}]");
	By eleWalkinDurationText = By.id("walkinDurationInfoText");
	By eleWalkinDurationMonth = By.xpath("//li[@class=' yr nav']");
	By eleWalkinDurationField = By.id("inp_walkinDurationDD");
	By eleWalkinDurationDefaultValue = By.id("hid_walkinDurationDD");
	By eleWalkinDurationDdValue = By.xpath("//a[@id='walkinDurationDD_${value}']");
	By eleWalkinStartTimeDD = By.id("inp_walkinStartTimeDD");
	By eleWalkinEndTimeDD = By.id("inp_walkinEndTimeDD");
	By eleWalkinTimeDefault = By.id("hid_walkinStartTimeDD");
	By eleWalkinStartTimingTotal = By.xpath("(//a[contains(@id,'walkinStartTimeDD')])");
	By eleWalkinTimeStart = By.xpath("(//a[contains(@id,'walkinStartTimeDD')])[${value}]");
	By eleWalkinEndTimingTotal = By.xpath("(//a[contains(@id,'walkinEndTimeDD')])");
	By eleWalkinTimeEnd = By.xpath("(//a[contains(@id,'walkinEndTimeDD')])[${value}]");
	By eleWalkinTimeError = By.id("walkinStartTime_err");
	By eleWalkinTimeStartTiming = By.xpath("//a[contains(@id,'walkinStartTimeDD') and text()='${value}']");
	By eleWalkinTimeEndTiming = By.xpath("//a[contains(@id,'walkinEndTimeDD') and text()='${value}']");
	
	
	By eleWalkinContactPerson = By.id("walkinContactPerson");
	By eleWalkinContactPersonError = By.id("walkinContactPerson_err");
	By eleWalkinContactNumber = By.id("walkinContactPhoneNo");
	By eleWalkinContactNumberError = By.id("walkinContactPhoneNo_err");
	By eleWalkinContactPersonMandatory = By.xpath("//label[contains(text(),'Walk-in Contact Person')]/span");
	By eleWalkinContactNumberNote = By.xpath("//em[contains(text(),'This will be visible to candidates')]");
	By eleWalkinContactNumberMandatory = By.xpath("//label[contains(text(),'Walk-in Contact Number')]/span");
	By eleWalkinContactPersonText = By.xpath("//label[@for='walkinContactPerson']");
	By eleWalkinStartTimeText = By.xpath("//label[@for='walkinStartTime']");
	By eleWalkinContactPersonNumberText = By.xpath("//label[@for='walkinContactPhoneNo']");
	By eleWalkinVenueField = By.id("walkinVenue");
	By eleWalkinVenueMandatory = By.xpath("//label[contains(text(),'Venue:')]/span");
	By eleWalkinVenueFieldError = By.id("walkinVenue_err");
	By eleGoogleUrlField = By.id("locationUrl");
	By eleGoogleOpenFieldText = By.xpath("//label[@for='locationUrl']");
	By eleGoogleUrlLink = By.id("openWalkinMap");
	By eleGoogleUrlIcon = By.xpath("//a[@id='gMapTT']/small");
	By eleGoogleUrlIconToolTipText = By.xpath("//p[contains(text(),'${value}')]");
	By eleLocationLayer = By.xpath("//p[contains(text(),'Select Location')]");
	By eleGoogleUrlIconToolTipLink = By.xpath("//a[contains(text(),'${value}')]");
	By eleUseLocationOnLocationLayer = By.id("useMapLocation");
	By eleSearchOnLocationLayer = By.id("gMapURL");
	By eleWalkinDateFieldLabel=By.xpath("//label[contains(text(),'${value}')]");
	By eleFirstGoogleLocationOption=By.xpath("(//div[@class='pac-item'])[1]");
	By eleContactPhoneText=By.xpath("//em[text()='Note: This will be visible to Applicants']");
	By eleWalkinDetailOnReqDetailsPage=By.xpath("//p[contains(.,'${value}')]");
	By eleVenueAddressDD = By.xpath("//div[@id='addressSuggestionWrap']//i");
	By eleVenueSavedAddressList=By.xpath("(//ul[@class='suggestionList']//li)[1]");
	By eleWalkinDetailOnPreviewPage=By.xpath("//div[contains(text(),'${value}')]");
	By eleAddVideoLink=By.xpath("//a[text()='${value}']");
	By eleAddVideoLinkMandatory=By.xpath("//label[contains(text(),'Add Video URL')]//span[text()='*']");
	By elePresentationBeforeVeido=By.xpath("//div[@id='brandingVideoUrlDiv']/preceding-sibling::div//label[contains(text(),'${value}')]");
	By eleAddVideoDD = By.id("inp_brandingVideodd");
	By eleTotalAddedVideo=By.xpath("//ul[@id='ul_brandingVideodd']//li");
	By eleFirstVideo=By.xpath("(//ul[@id='ul_brandingVideodd']//li)[1]/a");
	By eleVideoThumbnail=By.xpath("//a[@id='selectedVideoThumbNail']/img");
	By eleVideoUrlLabel=By.xpath("//label[contains(text(),'${label}')]");
	By eleRefreshList=By.xpath("//label[contains(text(),'${value}')]/parent::div//a[text()='${value}']");
	By eleMediaOnPreview=By.xpath("//div[text()='${type}']/parent::div//div[@class='media mediaSize']");
	By eleMediaViewDownloadOnPreview=By.xpath("(//div[text()='${value}']/parent::div//div[@class='media mediaSize'])[1]//div[contains(text(),'${value}')]");
	By eleJobDescriptionOnPreview=By.xpath("//div[contains(@class,'jobdescriptionWpr')]//div[text()='${value}']");
	By eleJobDescriptionRolesAndResponsibilityOnPreview=By.xpath("//div[contains(@class,'jobdescriptionWpr')]//div[text()='${value}']/parent::div");
	By eleJobDescriptionValuesOnPreview=By.xpath("(//div[contains(@class,'jobdescriptionWpr')]//div[text()='${value}']/parent::div//p)[1]");
	By eleJobDescriptionValuesOnPreviewForClassified=By.xpath("(//div[text()='${value}']/following-sibling::div[@class='reviewContList'])[1]");
	By eleOtherSalryValuesOnPreviewForClassified=By.xpath("//label[text()='Other Salary']/parent::li//p");
	By eleCLJobEditor=By.xpath("//textarea[@id='${value}_editorCL']");
	By eleNextBtn=By.xpath("//input[@value=' Next']");
	
	By successmessage=By.xpath("(//div[contains(@class,'psuccess')])[1]");
	By prefillFromOtherReqDD = By.xpath("(//ul[@class='DDsearch']//input)[1]");
	By countPrefillFromOtherReq = By.xpath("//ul[@id='ul_projectList']//li");
	By BtnReqOverviewOnAdditionalDetails = By.xpath("(//div[contains(@class,'psuccess')])[1]//a");
	By previewReqBtn = By.id("previewProject");
	By savePreviewBtn = By.id("submitPreview");
	By eleEmploymentType=By.id("inp_empTypeDD");
	By eleMandatoryStarSymbol=By.xpath("//label[contains(text(),'${field}')]/span[text()='*']");
	By eleNextElementOfJobDesignation=By.xpath("(//label[contains(text(),'Job Title/Designation')]/../following-sibling::div//label)[1]");
	By eleEmploymentTypeDDValue=By.xpath("(//ul[@id='ul_empTypeDD']//a[1])[${Value}]");
	By eleFieldNameOnPreview=By.xpath("//div[contains(@class,'reviewSubHead')]");
	By eleSpecificFieldNameODPreview=By.xpath("//div[contains(@class,'reviewSubHead')][${value}]");
	By eleEmploymentTypeValue=By.xpath("//div[contains(@class,'reviewSubHead') and text()='Employment Type']/following-sibling::p");
	By eleEmplymentTypeInDD=By.xpath("//ul[@id='ul_empTypeDD']//a[text()='${Value}']");
	By eleReqErrorMessageText=By.xpath("//div[contains(@class,'perror')]//span");
	By eleLocationSelected = By.xpath("//ul[@id='idCity']//span[text()='${loc}']");
//	By RadioBtnInternationalLoc = By.xpath("//input[@id='fillIntrLoc']");
//	By internationalLocDD = By.xpath("//input[@id='inp_internationalLocation']");
	By internationalJobLocOption = By.xpath("(//ul[@id=\"ul_internationalLocation\"]//a[text()='${IntLoc}'])[1]");
	By elePrefillHeading = By.xpath("//ul[@id='reqDDTabs']//a");
	By eleCityInternationalLoc = By.xpath("//ul[@class='refinItms']//li//span");
	By totalGroupCount = By.xpath("(//em[@id='totalRecord'])[1]");
	By eleCancelSelectionStage= By.id("closeStageBtn");
	By groupCount = By.xpath("//ul[@id='ul_hiringFordd']//li");
	By eleRequirementNameOnCvDetailsPage = By.xpath("//div[@class='pb5 pt5']//a");
	By recruiterNameDD = By.xpath("//ul[@id='ul_selListAndAddBtn']//a");
	By HmOnDD = By.xpath("(//select[@id='selectHm']//option)[2]");
	By eleHiringForOnReqPage = By.xpath("//label[text()='${string}']");
	By workMaxExpSize= By.xpath("//select[@id='maxExp']//option");
	By elePreviewPageEnteredValues = By.xpath("//label[text()='${string}']/following-sibling::p");
	By eleFirstReqFromPrefillList = By.xpath("(//ul[@id='ul_projectList']//li)[1]");
	By eleReqHeading = By.xpath("//a[text()='${string}']");
	By chkCustomFilters = By.name("filterFlag");
	By selectFirstGroupFrmDD = By.xpath("(//ul[@id='ul_hiringFordd']//a)[1]");
	By eleCompanyWebsite = By.id("website");
	By eleContactPerson = By.id("contactPerson");
	By elePhoneNumber = By.id("contactPhoneNo");
	By eleContactDetails = By.xpath("//label[text()='${string}']/following-sibling::p");
	//By elePreviewPage = By.xpath("//label[text()='${keyValue}']/following-sibling::p");
	By eleSalaryHolder = By.xpath("//label[text()='${keyvalue}']/following-sibling::p");
	By eleKeywordsPreview = By.xpath("//label[text()='${keywords} ']/following-sibling::span");
	By eleAddNewQuestionaire = By.id("c_quest");
	By questionareName = By.id("questionnairName");
	By eleAddNewQuestionbtn = By.xpath("//div[@id='addanother']//a");
	By eleQuestionOnLightbox = By.id("question_name");
	By eleAnsTypeQuestionaire = By.xpath("//li[text()='${string}']//input");
	By eleAnswersQuestionaire = By.xpath("(//div[@id='enterAns_Id']//input)[${string}]");
	By eleSaveQuestion = By.id("saveQuestionButton");
	By btnSaveQuestionaire = By.id("save_questionaire");
	By eleQuestionaireLightbox = By.xpath("//a[text()='${string}']");
	By eleTagAddedKeywords = By.xpath("//li[@class=' tagList']");
	By existingQuestionaire = By.id("inp_createQuestionnairedd");
	By selectQuestionaireFromExisting = By.xpath("//ul[@id='ul_createQuestionnairedd']//a[text()='${string}']");
	By questionDisplayedOnQuestionaire = By.xpath("//div[@class=' lblock']//strong[text()='${string}']");
	By eleDeleteIconOnQuestionaire = By.xpath("//a[@class=' delIcon']");
	By errQuestionaireName = By.xpath("//div[text()='${string}']");
	By errQuestionName = By.id("question_name_err");
	By errAnsName = By.id("ansList10_err");
	By fillAllAnsOnQues = By.id("ansList${string}");
	By eleCancelLightbox = By.xpath("(//a[text()='Cancel'])[1]");
	By chkMandatoryQues = By.id("mandatory");
	By eleVariableAmountOnPreview = By.xpath("//span[@class='salIconWr']//span[contains(text(),'${variable}% variable')]");
	By eleCancelUpdateJob=By.xpath("//input[@id='choose_project']/following-sibling::a");
	By eleUpdateJobPopup=By.xpath("//p[text()='Update Posted Jobs']");
	By eleWalkinDetailsOnPreview=By.xpath("//label[contains(text(),'${value}')]");
	By eleWalkinDetailsValueOnPreview=By.xpath("//p[contains(text(),'${value}')]");
	By eleKeySkillOnRequisitionPreview = By.xpath("//div[@class='keySkills']//li[text()='JAVA']");
	By eleErrorMessageForContactDetailsField= By.xpath("//div[text()='${message}']");
	By eleResponseFiltertab = By.id("tab3");
	By eleSaveProjectTab3 = By.xpath("//input[@value='Save Project']");
	
	By recruiterNameSelectByText = By.xpath("//a[text()='${string}']");
	public By countOfJob=By.xpath("//div[@class='fl jListHead']//div[contains(text(),'${JobName}')]");

	//By test = By.xpath("(//ul[@id='reqDDTabs']//a)[${string}]");

	public boolean verifyKeywordTextBoxEmpty()
	{
		return isDisplayed(eleTagAddedKeywords);
	}
	public void userSelectQuestionaireCreatedAboveFromExisting()
	{
		click(existingQuestionaire);
		String questionaireName= ReadWritePropertyFile.getProperty("questionaireName",
				fileSystemPathTillTestData() + "Data.properties");
		String expectedQuestionaireName = questionaireName + " | Created by You";
click(parameterizedLocator(selectQuestionaireFromExisting,expectedQuestionaireName));
	}
	public boolean OneQuestionDisplayedAgainstQuestionaire()
	{	
		String questionDisplayed= ReadWritePropertyFile.getProperty("questionCreated",fileSystemPathTillTestData() + "Data.properties");
		return isDisplayed(parameterizedLocator(questionDisplayedOnQuestionaire, questionDisplayed));
		//return actualQuestionDisplayed.contains(questionDisplayed);
	}
	public boolean optionssAgainstEveryQuestion(String option1, String option2)
	{
		return isDisplayed(parameterizedLocator(eleQuestionaireLightbox,option1)) &&
				isDisplayed(parameterizedLocator(eleQuestionaireLightbox,option2)) &&
				isDisplayed(eleDeleteIconOnQuestionaire);
	}
	public void clickOnDeleteIconOnQues()
	{
		click(eleDeleteIconOnQuestionaire);
	}
	public boolean verifyNoQuestionDisplayed()
	{
		String questionDisplayed= ReadWritePropertyFile.getProperty("questionCreated",fileSystemPathTillTestData() + "Data.properties");
		return !isDisplayed(parameterizedLocator(questionDisplayedOnQuestionaire,questionDisplayed));
	}

	/**
	 * To fill in the requirement name and return Requirement Name
	 *
	 * @author rachit.mehrotra
	 */
	@SuppressWarnings(value = "static-access")
	public String fillRequirementName() {
		driver.navigate().refresh();
		wait.hardWait(2);
//		wait.waitForPageToLoadCompletely();
		String requirementName = "Test_Requirement Name " + System.currentTimeMillis();
		sendKeys(requirementTitle, requirementName);
		TestNGLogUtility.info("User fills requirement name as "+requirementName);
		requirementDetails.put("requirementName", requirementName);
		ReadWritePropertyFile.setProperty("createdRequirementName",requirementName,fileSystemPathTillTestData() + "Data.properties");
		this.requirementName = requirementName;
		return requirementName;
	}

	/**
	 * To fill in the job title
	 * 
	 * @author rachit.mehrotra
	 */
	public String fillJobTitle() {
		String jobTitle = "Job Title_" + GenericFunctions.generateRandomStrings(8, "String");
		sendKeys(this.jobTitle, jobTitle);
		requirementDetails.put("jobTitle", jobTitle);
		return jobTitle;
	}

	/**
	 * To fill in JD
	 * 
	 * @author rachit.mehrotra
	 */
	public String fillInJD() {
		switchToFrame(jobDescription);
		sendKeys(By.tagName("body"), jobDescriptionText);
		requirementDetails.put("jobDescription", jobDescriptionText);
		switchToDefaultContent();
		return jobDescriptionText;
	}

	/**
	 * To fill in candidate details
	 * 
	 * @author rachit.mehrotra
	 *
	 */
	public String fillCandidateDetails() {
		click(fillCandidateDetails);
		switchToFrame(candidateDetailsEditor);
		sendKeys(By.tagName("body"), candidateDetail);
		requirementDetails.put("candidateDetail", candidateDetail);
		switchToDefaultContent();
		return candidateDetail;
	}

	/**
	 * To select the value from the currency DD
	 * 
	 * @param currencyType
	 * @author rachit.mehrotra
	 */
	public void selectCurrencyOfSalary(String currencyType) {
		requirementDetails.put("currencyType", currencyType);
		click(salaryCurrency);
		if (currencyType.equals("INR")) {
			wait.waitForElementToBeClickable(rupeesLocator);
			click(rupeesLocator);
		} else if (currencyType.equals("USD")) {
			wait.waitForElementToBeClickable(usdLocator);
			click(usdLocator);
		}
	}

	/**
	 * To select minCTC and maxCTC
	 * 
	 * @param ctcType
	 * @param ctcValue
	 * @author rachit.mehrotra
	 */
	public String fillTheCTC(String ctcType, String ctcValue) {
		requirementDetails.put(ctcType, ctcValue);
		if (ctcType.equals("minCTC")) {
			WebElement we = getElement(minSalary);
			Select select = new Select(we);
			select.selectByValue(ctcValue.replaceAll(",", ""));
		} else if (ctcType.equals("maxCTC")) {
			WebElement we1 = getElement(maxSalary);
			Select select = new Select(we1);
			select.selectByValue(ctcValue.replaceAll(",", ""));
		}
		return ctcValue;
	}

	/**
	 * To check the show salary checkbox
	 * 
	 * @author rachit.mehrotra
	 */
	public void selectShowSalaryToJobSeekers() {
		click(showSalaryToJobSeeker);
		TestNGLogUtility.info("show salary checkbox checked");
	}

	/**
	 * To add more salary details
	 * 
	 * @author rachit.mehrotra
	 */
	public String addMoreSalaryDetails(String migrationStatus) {
		click(enterMoreSalaryDetails);
		if (migrationStatus.equals("JP migrated")) {
			switchToFrame(otherSalaryDetails);
			sendKeys(By.tagName("body"), otherSalaryDetailsText);
			switchToDefaultContent();
		} else {
			sendKeys(eleOtherSalaryNonMigrated, otherSalaryDetailsText);
		}
		TestNGLogUtility.info("other salary details as " + otherSalaryDetailsText);
		return otherSalaryDetailsText;
	}

	/**
	 * To fill the min and max experience
	 * 
	 * @author rachit.mehrotra
	 * @param expType
	 * @param expValue
	 */
	public void fillTheExp(String expType, String expValue) {
		if (expType.equals("minExp")) {
			WebElement we2 = getElement(minExp);
			Select select = new Select(we2);
			select.selectByValue(expValue);
		} else if (expType.equals("maxExp")) {
			WebElement we3 = getElement(maxExp);
			Select select = new Select(we3);
			select.selectByValue(expValue);
		}
		requirementDetails.put(expType, expValue);
		wait.hardWait(1);
	}

	/**
	 * To fill in the keyskills
	 * 
	 * @author rachit.mehrotra
	 * @param skills
	 */
	public void fillTheKeywords(String skills) {
		List<String> skillsList = Arrays.asList(skills.split(","));
		for(String skill : skillsList) {
			wait.waitForElementToBeClickable(keywords);
			click(keywords);
			getElement(keywordEditor).sendKeys(skill);
			wait.hardWait(1);
			getElement(keywordEditor).sendKeys(Keys.ENTER);
			wait.hardWait(1);
		}
		requirementDetails.put("keywords", skillsList);
		click(keywordsLabel);
	}

	/**
	 * To click on remove keywords
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnClearKeyword() {
		click(removeKeyword);
	}

	/**
	 * To fill in the job locations
	 * 
	 * @author rachit.mehrotra
	 * @param locations
	 */
	public void fillInTheJobLocations(String locations) {
		List<String> locationsList = Arrays.asList(locations.split(","));
		if (!isDisplayed(eleJobLocations)) {
			for (String location : locationsList) {
				click(locationDD);
				wait.hardWait(1);
				click(parameterizedLocator(jobLocatorOption, location));
			}
			requirementDetails.put("jobLocations", locations);
		}
		wait.hardWait(1); // for prevent CSRF attack
	}

	/**
	 * To clear the location list
	 * 
	 * @author rachit.mehrotra
	 */
	public void clearLocation() {
		click(locationsClear);
	}

	/**
	 * To click on international location
	 * 
	 * @author rachit.mehrotra
	 */
	public void checkInternationalLocation() {
		click(internationalLocationCheckbox);
	}

	/**
	 * To select internationalLocation
	 * 
	 * @author rachit.mehrotra
	 * @param location
	 */
	public void selectInternationalLocation(String location) {
		click(internationalLocationDD);
		List<String> internationalLocationList = Arrays.asList(location.split(","));
		for (String internationalLocation : internationalLocationList) {
			click(parameterizedLocator(internationalJobLocation, internationalLocation));
			wait.hardWait(1);
		}
		requirementDetails.put("internationalLocation", location);
	}

	/**
	 * To fill in other's of other country
	 * 
	 * @author rachit.mehrotra
	 * @param otherCountry
	 */
	public void fillInOtherCountry(String otherCountry) {
		List<String> listOfOtherCountry = Arrays.asList(otherCountry.split(","));
		for (String otherCountryOption : listOfOtherCountry) {
			sendKeys(otherCountryIdSelector, otherCountryOption);
			click(parameterizedLocator(otherCountrySaveOrCancel, "Save"));
		}
	}

	/**
	 * To click on button on create requirement page
	 * 
	 * @author rachit.mehrotra
	 * @param btnText
	 */
	public void clickOperationButton(String btnText) {
		wait.waitForProcessingToDisappear(10, 3);
		click(addRequirementBtn);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * To post a job corresponding to a requirement
	 * 
	 * @author rachit.mehrotra
	 * @param jobPlatform
	 */
	public void postJobToRequirement(String jobPlatform) {
		if (jobPlatform.contains("Naukri")) {
			click(checkboxOfJobType);
			WebElement we = getElement(jobPostType);
			Select select = new Select(we);
			if (jobPlatform.contains("Private Job")) {
				select.selectByVisibleText("Naukri Private Job");
			} else if (jobPlatform.contains("Hot Vacancy")) {
				select.selectByVisibleText("Hot Vacancy");
			} else if (jobPlatform.contains("Classified")) {
				select.selectByVisibleText("Classified Job");
			} else if (jobPlatform.contains("Premium")) {
				select.selectByVisibleText("Premium Vacancy");
			}
		}
		if (jobPlatform.contains("Career Site Job")) {
			click(csJobCheckbox);
		}
	}
	
	/**
	 * To select the degree choice
	 * 
	 * @author rachit.mehrotra
	 * @param degreeStandard
	 * @param choiceOfDegreeString
	 * @param degreeStandardString
	 * @param degreeString
	 * @param specializationString
	 */
	public void selectDegree(String degreeStandard, String choiceOfDegreeString, String degreeStandardString,
			String degreeString, String specializationString) {
		if (degreeStandardString.contains("Choose Graduation Degree")) {
			click(parameterizedLocator(degreeSelector, degreeStandard, " " + choiceOfDegreeString));
			click(parameterizedLocator(ugCourseSelector, degreeString));
			click(parameterizedLocator(ugCourseSpecialization, "Any Specialization"));
			click(parameterizedLocator(ugCourseSpecialization, specializationString));
		}
		if (degreeStandardString.contains("Choose Post Graduation Degree")) {
			click(parameterizedLocator(degreeSelector, degreeStandard, " " + choiceOfDegreeString));
			click(parameterizedLocator(pgCourseSelector, degreeString));
			click(parameterizedLocator(pgCourseSpecialization, "Any Specialization"));
			click(parameterizedLocator(pgCourseSpecialization, specializationString));
		}
		if (degreeStandardString.contains("Choose Doctorate Degree")) {
			click(parameterizedLocator(ppgSelectector, degreeStandard, choiceOfDegreeString));
			click(parameterizedLocator(ppgCourseSelector, degreeString));
			click(parameterizedLocator(ppgCourseSpecialization, specializationString));
		}
	}

	/**
	 * To check the tab of education for a degree standard
	 * 
	 * @author rachit.mehrotra
	 * @param labelString
	 * @param degreeString
	 * @return
	 */
	public boolean checkLabelForEducation(String labelString, String degreeString) {
		if(degreeString.equals("Graduation"))
			return getText(ugCourseSpecializationTag).contains(labelString) ? true : false;
		if(degreeString.equals("Post Graduation"))
			return getText(pgCourseSpecializationTag).contains(labelString) ? true : false;
		if (degreeString.equals("Doctorate"))
			return getText(ppgCourseSpecializationTag).contains(labelString) ? true : false;
		return false;
	}

	/**
	 * To chose the And/Or of two stages of courses
	 * 
	 * @author rachit.mehrotra
	 * @param replacementRelation
	 */
	public void clickOnCourseRelationOfCourses(String replacementRelation) {
		click(parameterizedLocator(optionOfUgAndPgRelation, " " + replacementRelation));
	}

	/**
	 * To select the ppg
	 * 
	 * @author rachit.mehrotra
	 * @param ppgselector
	 */
	public void selectPpgSelector(String ppgselector) {
		click(parameterizedLocator(ppgSelector, ppgselector));
	}

	/**
	 * To fill in the industry/functional area/role
	 * 
	 * @author rachit.mehrotra
	 * @param requirementAttributeKey
	 * @param requirementAttributeValue
	 */
	public void fillInRequirementDD(String requirementAttributeKey, String requirementAttributeValue) {
		String modifiedRequirementAttributeValue = requirementAttributeValue.substring(0,
				requirementAttributeValue.length() - 2);
		if (requirementAttributeKey.contains("Industy")) {
			click(industryDD);
			sendKeys(industryDD, modifiedRequirementAttributeValue);
			click(industrySugg);
		}
		if (requirementAttributeKey.contains("Functional Area")) {
			click(functionalArea);
			sendKeys(functionalArea, modifiedRequirementAttributeValue);
			getElement(functionalSugg).click();
		}
		if (requirementAttributeKey.contains("Role")) {
			click(jobRole);
			sendKeys(jobRole, modifiedRequirementAttributeValue);
			getElement(jobRoleSugg).click();
		}
		TestNGLogUtility.info(requirementAttributeKey + " is filled with " + requirementAttributeValue);
	}

	/**
	 * To click on add requirement button
	 * 
	 * @author rachit.mehrotra
	 */
	public void addRequirementButtonClick() {
		click(saveRequirement);
	}

	/**
	 * To assure the presence of the questionnaire lightbox
	 * 
	 * @author rachit.mehrotra
	 * @param titlePlaceHolder
	 * @return
	 */
	public boolean presenceOfQuestionnaireLightbox(String titlePlaceHolder) {
		return isDisplayed(parameterizedLocator(questionnaireLightBoxTitle, titlePlaceHolder));
	}

	/**
	 * To click on questionnaire lightbox action
	 * 
	 * @author rachit.mehrotra
	 * @param buttonLocatorText
	 */
	public void clickOnQuestionnaireAction(String buttonLocatorText) {
		if (buttonLocatorText.contains(buttonLocatorText)) {
			click(skipQuestionnaireNowButton);
		}
	}

	/**
	 * To check the redirection of the requirement overview page
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean redirectionToRequirementOverviewPage() {
		requirementOverviewPageURL = getCurrentURL();
		return (isDisplayed(requirementPlaceholderOnOverview)
				&& (isDisplayed(parameterizedLocator(requirementNamePlaceHolder,requirementDetails.get("requirementName").toString())))) ;
	}

	/**
	 * To fill the company name and about company
	 * 
	 * @author rachit.mehrotra To fill the company details and about text
	 */
	public void fillInCompanyNameAndAboutDetails(String migrationStatus) {
		if (getAttribute(companyName_txt, "readOnly") == null)
			sendKeys(companyName_txt, companyName);
		if (migrationStatus.equals("JP migrated")) {
			switchToFrame(aboutCompany_iframe);
			sendKeys(By.tagName("body"), aboutCompany);
			switchToDefaultContent();
		}
		else
			sendKeys(aboutCompany_txt, aboutCompany);
		TestNGLogUtility.info("about company " + aboutCompany);
	}

	/**
	 * To fill in the given string in about company
	 * 
	 * @author rachit.mehrotra
	 * @param aboutCompany
	 */
	public void fillInAboutCompany(String aboutCompany, String migrationStatus) {
		if (migrationStatus.equals("JP migrated")) {
			switchToFrame(aboutCompany_iframe);
			sendKeys(By.tagName("body"), aboutCompany);
			switchToDefaultContent();
		} else
			sendKeys(aboutCompany_txt, aboutCompany);
		TestNGLogUtility.info("about company text " + aboutCompany);
	}

	/**
	 * To verify the edit job or requirement tab
	 * 
	 * @author rachit.mehrotra
	 * @param tabType
	 * @return boolean
	 */
	public boolean verifyTheEditPageOfRequirementOrJob(String tabType) {
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
		if(tabType.contains("job")) {
			return getText(activeJobOrRequirementTab).contains("Job Details") && getAttribute(activeJobOrRequirementTab, "class").contains("active");
		}
		if(tabType.contains("Requirement")) {
			return getText(activeJobOrRequirementTab).contains("Requirement Details") && getAttribute(activeJobOrRequirementTab, "class").contains("active");
		}
		return false;
	}

	/**
	 * To get the text of JD iframe
	 * 
	 * @author rachit.mehrotra
	 * @return JD text
	 */
	public String getTextOfJobDescription() {
		switchToFrame(jobDescription);
		String bodyTextOfJD = getText(By.tagName("body"));
		switchToDefaultContent();
		return bodyTextOfJD;
	}

	/**
	 * To get the text of the candidate details
	 * 
	 * @author rachit.mehrotra
	 * @return Candidate Details Text
	 */
	public String getTextOfCandidateDetails() {
		switchToFrame(candidateDetailsEditor);
		String bodyTextOfCandidateDetails = getText(By.tagName("body"));
		switchToDefaultContent();
		return bodyTextOfCandidateDetails;
	}

	/**
	 * To verify the text of JD on edit to the text of creation
	 * @author rachit.mehrotra
	 * @return boolean depending on the text match
	 */
	public boolean verifyTheJobDescriptionText() {
		return getTextOfJobDescription().contains(requirementDetails.get("jobDescription").toString());
	}

	/**
	 * To verify the of Candidate Detail on edit to the Candidate detail at the time
	 * of creation
	 * 
	 * @author rachit.mehrotra
	 * @return boolean depending on text match
	 */
	public boolean verifyTheCandidateDetails() {
		return getTextOfCandidateDetails().contains(requirementDetails.get("candidateDetail").toString());
	}

	/**
	 * To return the error message of requirement title
	 * 
	 * @author rachit.mehrotra
	 * @return error message
	 */
	public String getRequirementTitleError() {
		return getText(eleprojectNameErrorMessage);
	}

	/**
	 * To return the job title error message
	 * 
	 * @author rachit.mehrotra
	 * @return error message
	 */
	public String getJobTitleError() {
		return getText(elejobTitleErrorMessage);
	}

	/**
	 * To return the error message basis salaryType
	 * 
	 * @author rachit.mehrotra
	 * @param salaryType
	 * @return error message
	 */
	public String getSalaryErrorMessage(String salaryType) {
		if (salaryType.equals("minimum salary"))
			return getText(eleMinSalaryErrorMessage);
		if (salaryType.equals("maximum salary"))
			return getText(eleMaxSalaryErrorMessage);
		return null;
	}

	/**
	 * To verify the work experience error message basis workExperienceType
	 * 
	 * @author rachit.mehrotra
	 * @param workExperienceType
	 * @return error message
	 */
	public String getWorkExperienceErrorMessage(String workExperienceType) {
		if (workExperienceType.equals("minimum experience"))
			return getText(eleMinWorkExperienceErrorMessage);
		if (workExperienceType.equals("maximum experience"))
			return getText(eleMaxWorkExperienceErrorMessage);
		return null;
	}

	/**
	 * To get the location error message
	 * 
	 * @author rachit.mehrotra
	 * @return error message
	 */
	public String getLocationErrorMessage() {
		return getText(eleLocationErrorMessage);
	}

	/**
	 * To get the keyword error message
	 * 
	 * @author rachit.mehrotra
	 * @return error message
	 */
	public String getKeywordErrorMessage() {
		return getText(eleKeywordErrorMessage);
	}

	/**
	 * To verify the actual error message with the UI
	 * 
	 * @author rachit.mehrotra
	 * @param actualErrorMessage
	 * @return true/false
	 */
	public boolean verifyTheRequirementTitleError(String actualErrorMessage) {
		return getRequirementTitleError().equals(actualErrorMessage);
	}

	/**
	 * To verify the actual error message with the UI
	 * 
	 * @author rachit.mehrotra
	 * @param actualErrorMessage
	 * @return true/false
	 */
	public boolean verifyTheJobTitleError(String actualErrorMessage) {
		return getJobTitleError().equals(actualErrorMessage);
	}

	/**
	 * to verify the salary error message with the UI
	 * 
	 * @author rachit.mehrotra
	 * @param errorMessage
	 * @param salaryType
	 * @return true/false
	 */
	public boolean verifyTheSalaryErrorMessage(String errorMessage, String salaryType) {
		return getSalaryErrorMessage(salaryType).equals(errorMessage);
	}

	/**
	 * to verify the work experience error message with the UI
	 * 
	 * @author rachit.mehrotra
	 * @param errorMessage
	 * @param experienceType
	 * @return true/false
	 */
	public boolean verifyTheWorkExperienceErrorMessage(String errorMessage, String experienceType) {
		return getWorkExperienceErrorMessage(experienceType).equals(errorMessage);
	}

	/**
	 * To verify the error message on location
	 * 
	 * @author rachit.mehrotra
	 * @param actualErrorMessage
	 * @return true/false
	 */
	public boolean verifyTheLocationError(String actualErrorMessage) {
		return getLocationErrorMessage().equals(actualErrorMessage);
	}

	/**
	 * To verify the error message on keyword
	 * 
	 * @author rachit.mehrotra
	 * @param actualErrorMessage
	 * @return true/false
	 */
	public boolean verifyTheKeywordError(String actualErrorMessage) {
		return getKeywordErrorMessage().equals(actualErrorMessage);
	}

	/**
	 * To click on the company name label
	 */
	public void clickOnAboutCompanyLabel() {
		click(eleAboutCompanyLabel);
	}

	/**
	 * To verify the error message for about company
	 * 
	 * @param errorMessage
	 * @return true/false basis comparison
	 */
	public boolean verifyTheErrorMessageOfAbtCompanyEditore(String errorMessage) {
		boolean flagPresence = false;
		if (errorMessage.equals("No Error")) {
			wait.resetImplicitTimeout(1);
			flagPresence = !isDisplayed(eleAboutCompanyErrorMessage);
			wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
		} else
			flagPresence = getText(eleAboutCompanyErrorMessage).equals(errorMessage);
		return flagPresence;
	}

	/**
	 * To click on industry label of requirement creation
	 */
	public void clickOnIndustryLabel() {
		click(eleIndustryLabel);
	}

	/**
	 * To check for the presence and text of error message for industry
	 * 
	 * @param expectedErrorMessage
	 * @return true/false basis comparison
	 */
	public boolean presenceOfErrorMessageForIndustry(String expectedErrorMessage) {
		return getText(eleIndustryErrorMessage).equals(expectedErrorMessage);
	}

	/**
	 * To check for the presence and text of error message for functional area
	 * 
	 * @param expectedErrorMessage
	 * @return true/false basis comparison
	 */
	public boolean presenceOfErrorMessageForFunctionalArea(String expectedErrorMessage) {
		return getText(eleFunctionalAreaErrorMessage).equals(expectedErrorMessage);
	}

	/**
	 * to fill the reference code of the requirement
	 */
	public void fillInReferenceCodeForRequirement() {
		String referenceCodeOfRequirement = GenericFunctions.generateRandomStrings(3, "Number");
		sendKeys(addReferenceCodeField, referenceCodeOfRequirement);
		requirementDetails.put("referenceCode", referenceCodeOfRequirement);
	}

	/**
	 * To select the group for the requirement
	 * 
	 * @param groupName
	 */
	public void selectTheGroupForRequirement(String groupName) {
		//wait.waitForPageToLoadCompletely();
		click(groupOrHiringFor);
		if (groupName.length() == 0)
			sendKeys(groupOrHiringFor, PropFileHandler.readProperty("GroupName"));
		else
			sendKeys(groupOrHiringFor, groupName);
		click(eleGroupSuggestorSelector);
		requirementDetails.put("groupName",groupName);
		wait.waitForOverlayProcessingToDisappear(2, 3);
	}
	public void selectGroup()
	{
		String groupName = PropFileHandler.readProperty("GroupName");
		selectTheGroupForRequirement(groupName);
	}


	/**
	 * to set the visibility of the requirement
	 * 
	 * @param visibilityStage
	 */
	public void setTheVisibilityStatusOfCandidate(String visibilityStage) {
		System.out.println("presence " + isDisplayed(visibilityDD));
		Select selectVis = new Select(getElement(visibilityDD));
		if (visibilityStage.equals("Visible to All in Group"))
			selectVis.selectByValue("1");
		else
			selectVis.selectByVisibleText(visibilityStage);
		requirementDetails.put("visibility", visibilityStage);
	}

	/**
	 * This method will create a requirement with some params
	 *setVisReq
	 * @param minCTC
	 * @param maxCTC
	 * @param minExp
	 * @param maxExp
	 * @param keyword
	 * @param location
	 * @param group
	 */
	public String createARequirement(String minCTC, String maxCTC, String minExp, String maxExp, String keyword,
			String location, String groupName) {
		String reqName = fillRequirementName();
		fillJobTitle();
		fillInJD();
		fillCandidateDetails();
		selectCurrencyOfSalary("INR");
		fillTheCTC("minCTC", minCTC);
		fillTheCTC("maxCTC", maxCTC);
		fillTheExp("minExp", minExp);
		fillTheExp("maxExp", maxExp);
		fillTheKeywords(keyword);
		fillInTheJobLocations(location);
		click(eleEmploymentType);
		click(parameterizedLocator(eleEmplymentTypeInDD, "Full Time, Freelance/Homebased"));
		selectTheGroupForRequirement(groupName);
		clickOperationButton("Add Requirement");
		return reqName;
	}

	/**
	 * To fill in the keyskills
	 *
	 * @author abhishek.dwivedi
	 * @param skills
	 */
	public void fillKeywords(String skills) {
		List<String> skillsList = Arrays.asList(skills.split(","));
		for (String skill : skillsList) {
			if (!isDisplayed(eleKeywordValue)) {
				click(keywords);
				getElement(keywordEditor).sendKeys(skill);
				wait.hardWait(1);
				getElement(keywordEditor).sendKeys(Keys.ENTER);
				wait.hardWait(1);
			}
		}
	}

	/**
	 * click Preview On Requirement Page
	 *
	 * @author udit.khanna
	 */
	public void clickPreviewOnRequirementPage() {
		click(elePreviewOnReqPage);
	}

	/**
	 * click Post On Preview Requirement Page
	 *
	 * @author udit.khanna
	 */
	public void clickPostOnPreviewRequirementPage() {
		wait.waitForPageToLoadCompletely();
		click(eleSubmitPreviewOnReqPage);
	}

	/**
	 * This method will select the questionnaire from list
	 * @return
	 */
	public String selectQuestionnaireFromList() {
		String questionnaireName = "";
		click(ddQuestionnaire);
		int size = getElements(eleQuestionnaireList).size();
		if (size > 0) {
			questionnaireName = getText(parameterizedLocator(eleSelectedQuestionnaire, String.valueOf(size - 2)));
			click(parameterizedLocator(eleSelectedQuestionnaire, String.valueOf(size - 2)));
		}

		return questionnaireName;
	}

	/**
	 * To verify Requirement is add successfully
	 * 
	 * @author himanshu.dua
	 * @return
	 */
	public boolean presenceOfSuccessMessageOfRequirementCreation() {
		wait.waitForProcessingToDisappear(10, 3);
		return isDisplayed(successmessage);
	}


	public void clickPrefillFromOtherRequirement()
	{
	//	jsUtil.executeJavascript("console.log(document.getElementById('inp_projectList'))");
		click(prefillFromOtherReqDD);
	//	jsUtil.executeJavascript("document.getElementById('inp_projectList').click();");
	}
	public boolean verifyCountOnPrefillOtherReqDD()
	{
		return  getElements(countPrefillFromOtherReq).size()==10;
	}
	public void clickRequirementOverviewSuccessMessage()
	{
		click(BtnReqOverviewOnAdditionalDetails);
	}
	public void previewSecondPageRequirementCreation()
	{
		wait.waitForProcessingToDisappear(10, 3);
		click(previewReqBtn);
		wait.waitForPageToLoadCompletely();
	}
	public void clickOnSaveRequirementPreviewPage()
	{
		click(savePreviewBtn);
	}
	/**
	 * To verify Employment Type dropdown is available on Requirement creation page
	 * 
	 * @author himanshu.dua
	 * @return
	 */
	public boolean presenceOfEmploymentTypeOnRequirementCreationPage() {
		wait.waitForProcessingToDisappear(10, 3);
		return isDisplayed(eleEmploymentType);
	}

	/**
	 * To verify field is mandatory on Requirement creation page
	 * 
	 * @author himanshu.dua
	 * @return
	 */
	public boolean verifyFieldIsMandatory(String fieldName) {
		wait.waitForProcessingToDisappear(10, 3);
		return isDisplayed(parameterizedLocator(eleMandatoryStarSymbol, fieldName));
	}

	/**
	 * To verify Employment Type is displayed after Job Designation on Requirement
	 * creation page
	 * 
	 * @author himanshu.dua
	 * @return
	 */
	public boolean verifyEmploymentTypeAfterJobDesignation(String fieldName) {
		wait.waitForProcessingToDisappear(10, 3);
		return getText(eleNextElementOfJobDesignation).contains(fieldName);
	}

	/**
	 * This function is verify Employment Type drop down value and their sequence
	 * 
	 * @author himanshu.dua
	 * @param expectedValue
	 * @param i
	 * @return
	 */
	public boolean verifyEmploymentTypeDdValue(String expectedValue, int i) {
		//wait.waitForProcessingToDisappear(10, 3);
		//click(eleEmploymentType);
		return getText(parameterizedLocator(eleEmploymentTypeDDValue, String.valueOf(i))).trim().equals(expectedValue);
	}

	/**
	 * This method is verify Employment Type field is available on preview page
	 * 
	 * @author himanshu.dua
	 * @param fieldName
	 * @return
	 */
	public boolean verifyEmploymentTypeOnPreviewPage(String fieldName) {
		wait.waitForProcessingToDisappear(10, 3);
		int size = getElements(eleFieldNameOnPreview).size();
		for (int i = 1; i <= size; i++) {
			if (getText(parameterizedLocator(eleSpecificFieldNameODPreview, String.valueOf(i))).trim()
					.equals(fieldName)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * This function is verify Employment Type value on preview page
	 * 
	 * @author himanshu.dua
	 * @param expectedValue
	 * @return
	 */
	public boolean verifyEmploymentTypeValueOnPreviewPage(String expectedValue) {
		wait.waitForProcessingToDisappear(10, 3);
		return getText(eleEmploymentTypeValue).trim().equals(expectedValue);
	}

	/**
	 * This method is used for choosing a Employment Type from list
	 * 
	 * @author himanshu.dua
	 * @param option
	 */
	public void clickEmploymentTypeOptionfromList(String option) {
		click(parameterizedLocator(eleEmplymentTypeInDD, option));
	}

	/**
	 * This method is used for choosing a Employment Type DD
	 * 
	 * @author himanshu.dua
	 */
	public void clickEmploymentTypeDD() {
		click(eleEmploymentType);
	}

	/**
	 * This function is verify correct variable text on requirement creation page
	 * 
	 * @author himanshu.dua
	 * @param expectedText
	 * @return
	 */
	public boolean verifyVariableTextOnCreationPage(String expectedText) {
		wait.waitForProcessingToDisappear(10, 3);
		return getText(eleNoVariableText).trim().equals(expectedText);
	}

	/**
	 * This method is verify variable change link is visible or not
	 * 
	 * @return
	 */
	public boolean verifyVariableChangeLinkOnCreationPage() {
		wait.waitForProcessingToDisappear(10, 3);
		return isDisplayed(linkVariableChange) && getText(linkVariableChange).trim().equals("Change");

	}

	/**
	 * This method is click on variable change link
	 * 
	 * @return
	 */
	public void clickVariableChangeLinkOnCreationPage() {
		wait.waitForProcessingToDisappear(10, 3);
		click(linkVariableChange);
	}

	/**
	 * This method is verify variable text field is visible or not
	 * 
	 * @return
	 */
	public boolean verifyVariableTextFieldOnCreationPage(String fieldName) {
		wait.waitForProcessingToDisappear(10, 3);
		return isDisplayed(eleVeriableTextField) && getText(eleVariableFieldText).trim().contains(fieldName);
	}

	/**
	 * This method is verify variable field is mandatory or not
	 * 
	 * @return
	 */
	public boolean verifyVariableFieldIsNotMandatory() {
		wait.waitForProcessingToDisappear(10, 3);
		return isDisplayed(eleVariableFieldMandatoryStarIcon);
	}

	/**
	 * This method is fill variable amount
	 * 
	 * @return
	 */
	public String enterVariableAmountOnCreationPage(String value) {
		String amount = "";
		wait.waitForProcessingToDisappear(10, 3);
		if (!value.contains("above 100")) {
			amount = GenericFunctions.generateRandomStrings(2, value);
			System.out.println("amount->> " + amount);
			wait.hardWait(2);
		} else if (value.equalsIgnoreCase("Blank")) {
			amount = " ";
		} else
			amount = GenericFunctions.generateRandomStrings(3, "Number");
		sendKeys(eleVeriableTextField, amount);
		return amount;
	}

	/**
	 * This method is verify variable value is displaying
	 * 
	 * @return
	 */
	public boolean verifyVariableValueIsDisplaying(String expectedValue) {
		return getAttribute(eleVeriableTextField, "value").trim().equals(expectedValue);
	}

	/**
	 * This method is verify text against variable field
	 * 
	 * @return
	 */
	public boolean verifyTextAgainstVariableField(String expectedValue) {
		return getText(eleTextAgainstVariableField).trim().contains(expectedValue);
	}

	public String calculateVeriableAmount(String variablePercent, String minAmount, String maxAmount) {
		if (variablePercent.equals(""))
			return "";
		minAmount = minAmount.replace(",", "");
		maxAmount = maxAmount.replace(",", "");
		int minVariable = (Integer.valueOf(minAmount) * Integer.valueOf(variablePercent)) / 100;
		int maxVariable = (Integer.valueOf(maxAmount) * Integer.valueOf(variablePercent)) / 100;
		return "Rs " + GenericFunctions.format(minVariable) + " - " + "Rs "
				+ GenericFunctions.format(maxVariable);
	}

	/**
	 * This method is verify variable amount against variable field
	 * 
	 * @return
	 */
	public boolean verifyVariableAmountAgainstVariableField(String variablePercent, String minAmount,
			String maxAmount) {
		String variableText = calculateVeriableAmount(variablePercent, minAmount, maxAmount) + " is variable";
		return getText(eleTextAgainstVariableField).trim().contains(variableText);
	}

	/**
	 * This method is verify variable amount on preview page
	 * 
	 * @return
	 */
	public boolean verifyVariableFieldAndValueOnPreviewPage(String expectedValue) {
		return isDisplayed(eleVariableFieldOnPreviewPage)
				&& getText(eleVariableFieldValueOnPreviewPage).trim().contains(expectedValue);
	}

	/**
	 * This method is click on star icon on keyword chip
	 * 
	 * @return
	 */
	public void clickOnStarOnKeywordChip(String keyword) {
		wait.waitForProcessingToDisappear(10, 3);
		if (getAttribute(parameterizedLocator(eleStarIconOnKeywordChip, keyword), "title").trim()
				.contentEquals("Mark " + keyword + " as \"must have\""))
			click(parameterizedLocator(eleStarIconOnKeywordChip, keyword));
	}

	/**
	 * This method is click requirement name
	 * 
	 * @return
	 */
	public void clickOnRequirementName(String reqName) {
		int count=1;
		wait.waitForProcessingToDisappear(10, 3);
		if (!isDisplayed(parameterizedLocator(eleRequirementName, reqName)) && count !=3) {
			pageRefresh();
			count++;
		}
		click(parameterizedLocator(eleRequirementName, reqName));
		switchToChildWindow();
	}

	/**
	 * This function is verifying selected and unselected Star icon is displaying on
	 * keyword
	 * 
	 * @author himanshu.dua
	 * @param keyword
	 * @param state
	 * @return
	 */
	public boolean verifyStarIconOnKeywordChip(String keyword, String state) {
		if (state.equalsIgnoreCase("Unselected"))
			flag = getAttribute(parameterizedLocator(eleStarIconOnKeywordChip, keyword), "title").trim()
					.contains("Mark " + keyword + " as \"must have\"");
		if (state.equalsIgnoreCase("Selected"))
			flag = getAttribute(parameterizedLocator(eleStarIconOnKeywordChip, keyword), "title").trim()
					.contains(keyword + " marked as \"must have\" keyword");
		if (state.equalsIgnoreCase("Disabled")) {
			flag = getAttribute(parameterizedLocator(eleStarIconOnKeywordChip, keyword), "style").trim()
					.contains("cursor: not-allowed");
		}
		return flag;
	}

	/**
	 * This method will hover on the star of any keyword
	 * 
	 * @param keyword
	 */
	public void HoverOnStarIcon(String keyword) {
		hover((parameterizedLocator(eleStarIconOnKeywordChip, keyword)));
	}

	/**
	 * This method verify the tooltip of star icon
	 * 
	 * @param keyword
	 * @param toolTip
	 * @return
	 */
	public boolean verifyStarIconToolTip(String keyword, String state) {
		HoverOnStarIcon(keyword);
		switch (state) {
		case "Selected":
			flag = getAttribute(parameterizedLocator(eleStarIconOnKeywordChip, keyword), "title").trim()
					.contains(keyword + " marked as \"must have\" keyword");
			break;
		case "Unselected":
			flag = getAttribute(parameterizedLocator(eleStarIconOnKeywordChip, keyword), "title").trim()
					.contains("Mark " + keyword + " as \"must have\"");
			break;
		case "Disabled":
			flag = getAttribute(parameterizedLocator(eleStarIconOnKeywordChip, keyword), "title").trim()
					.contains("Only 3 keywords can be marked as \"must have\"");
			break;

		default:
			break;
		}
		return flag;
	}

	/**
	 * This method will verify the Remove all keyword link and display text
	 * 
	 * @param text
	 * @return
	 */
	public boolean verifyRemoveAllTags(String text) {
		return isDisplayed(eleRemoveAllTag) && getText(eleRemoveAllTag).trim().equals(text);
	}

	/**
	 * This method is verifying the text under Keyword filed
	 * 
	 * @param text
	 * @return
	 */
	public boolean verifyTextUnderKeywordField(String text) {
		return isDisplayed(eleTextUnderKeywordField)
				&& getAttribute(eleTextUnderKeywordField, "textContent").contains(text);
	}

	/**
	 * This method is verifying the Keyword filed text on preview
	 * 
	 * @param text
	 * @return
	 */
	public boolean verifyKeywordFieldTextOnPreview() {
		return isDisplayed(eleKeywordFieldOnPreview)
				&& getText(eleKeywordFieldOnPreview).contains("Must have key skills");
	}

	/**
	 * This method is verifying Star on keyword chip on preview
	 * 
	 * @param text
	 * @return
	 */
	public boolean verifyStarOnKeywordChipOnPreview(String keyword) {
		return isDisplayed(parameterizedLocator(eleStarOnKeywordPreview, keyword));
	}

	/**
	 * This method is verifying keyword chip on preview
	 * 
	 * @param text
	 * @return
	 */
	public boolean verifyKeywordChipOnPreview(String keyword) {
		return isDisplayed(parameterizedLocator(eleKeywordOnPreview, keyword));
	}
		
		public void userNavigatedtoREqOverviewFRomCVDetails()
	{
		wait.waitForVisibilityOfElement(eleRequirementNameOnCvDetailsPage);
		click(eleRequirementNameOnCvDetailsPage);
		String requirementName = getElement(eleRequirementNameOnCvDetailsPage).getAttribute("title");
		requirementDetails.put("requirementName",requirementName);
		switchToChildWindow();
	}

	/**
	 * This method is verifying link are present against field in contact details
	 * 
	 * @param link
	 * @param field
	 * @return
	 */
	public boolean verifylinkinContactDetails(String field, String link) {
		return isDisplayed(parameterizedLocator(linkContactDetails, field, link));
	}

	/**
	 * This method is verifying Naukri recruiter profile is disabled
	 * 
	 * @param link
	 * @param field
	 * @return
	 */
	public boolean verifyNaukriRecruiterFieldIsDisabled() {
		return !getElement(eleNaukriRecruiterProfileField).isEnabled();
	}

	/**
	 * This method is verifying contact details as mandatory
	 * 
	 * @param field
	 * @return
	 */
	public boolean verifyContactDetailsIsMandatory(String field) {
		int size = getElements(parameterizedLocator(eleContactMandatoryFields, field)).size();
		return isDisplayed(parameterizedLocator(eleContactMandatoryField, field, String.valueOf(size)));
	}

	/**
	 * this method will uncheck the selected Naukri or career site job checkbox
	 * 
	 * @author himanshu.dua
	 * @param jobPlatform
	 */
	public void unselectJobTypeSelectedCheckbox(String jobPlatform) {
		if (jobPlatform.contains("Naukri")) {
			if (isSelected(checkboxOfJobType))
				click(checkboxOfJobType);
		}
		if (jobPlatform.contains("Career Site Job")) {
			if (isSelected(csJobCheckbox))
				click(csJobCheckbox);
		}
	}

	/**
	 * This method is click on link are present against field in contact details
	 * 
	 * @param link
	 * @param field
	 * @return
	 */
	public void clicklinkinContactDetails(String field, String link) {
		click(parameterizedLocator(linkContactDetails, field, link));
	}

	public boolean verifyAddProfilePageOnNewTab() {
		switchToChildWindow();
		flag = getCurrentURL().contains("mrp");
		return flag;
	}

	/**
	 * This method will verify Recruiter details after refresh
	 * 
	 * @param recruiterDetail
	 * @return
	 */
	public boolean verifyNaukriRecruiterDetailsAfterRefresh(String recruiterDetail) {
		return getAttribute(eleNaukriRecruiterProfileField, "value").equals(recruiterDetail);
	}

	public void fillTheKeywordsInSingleProfile(String skills) {
		List<String> skillsList = Arrays.asList(skills.split(","));
		for (String skill : skillsList) {
			click(keywords);
			getElement(keywordProject).sendKeys(skill);
			wait.hardWait(1);
			getElement(keywordProject).sendKeys(Keys.ENTER);
			wait.hardWait(1);
		}
		requirementDetails.put("keywords", skillsList);
		click(keywordsLabel);
	}

	/**
	 * This method will click on check box show salary to job seeker
	 */
	public void clickOnShowCtcToJobSeeker() {
		click(eleShowSalarytoJobSeeker);
	}

	/**
	 * This method is verify variable amount on preview page
	 * 
	 * @return
	 */
	public boolean verifyVariableFieldAndValueOnRequirementOverviewPage(String expectedValue) {
		return isDisplayed(eleVariableFieldOnPreviewPage)
				&& getText(eleVariableFieldValueOnRequirementDetailsPage).trim().contains(expectedValue);
	}

	/**
	 * This method will select the number of photos from list
	 * 
	 * @author himanshu.dua
	 * @param count
	 */
	public void selectPhotosFromList(int count) {
		click(elePhotoDD);
		int size = getElements(elePhotosList).size();
		if (size < count)
			count = size;
		for (int i = 1; i <= count; i++) {
			click(parameterizedLocator(eleSelectedPhotos, String.valueOf(i)));
		}
	}

	/**
	 * This method will unselect photos from list
	 * 
	 * @author himanshu.dua
	 * @param count
	 */
	public void unselectPhotoFromList(int count) {
		if (!isDisplayed(eleSelectedPhotos)) {
			click(elePhotoDD);
		}
		for (int i = 1; i <= count; i++) {
			if (getAttribute((parameterizedLocator(eleSelectedPhotos, String.valueOf(i))), "class").contains("chkd")) {
				click(parameterizedLocator(eleSelectedPhotos, String.valueOf(i)));
			}
		}
	}

	/**
	 * This method will verify rest of photos in the list will be disabled if 5
	 * photos are selected
	 * 
	 * @return
	 */
	public boolean verifyPhotosDisabled() {
		click(elePhotoDD);
		int num = 1;
		int size = getElements(elePhotosList).size();
		if (size > 5)
			num = 5 + 1;
		for (int i = num; i <= size; i++) {
			if (!isSelected(parameterizedLocator(eleSelectedPhotos, String.valueOf(i)))) {
				if (getAttribute(parameterizedLocator(eleSelectedPhotos, String.valueOf(i)), "class").equals("disbl"))
					flag = true;
				else {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * This function verify Photos checkbox is enabled
	 * 
	 * @author himanshu.dua
	 * @return
	 */
	public boolean verifyPhotosEnabled() {
		click(elePhotoDD);
		int size = getElements(elePhotosList).size();
		for (int i = 1; i <= size; i++) {
			if (!isSelected(parameterizedLocator(eleSelectedPhotos, String.valueOf(i)))) {
				if (!getAttribute(parameterizedLocator(eleSelectedPhotos, String.valueOf(i)), "class").equals("disbl"))
					flag = true;
				else {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * This method will hover on disabled photos checkbox.
	 * 
	 * @author himanshu.dua
	 * @return
	 */
	public int hoverOnDisabledCheckbox() {
		click(elePhotoDD);
		int value = 0;
		int size = getElements(elePhotosList).size();
		for (int i = 1; i <= size; i++) {
			value = i;
			if (!isSelected(parameterizedLocator(eleSelectedPhotos, String.valueOf(i)))
					&& getAttribute(parameterizedLocator(eleSelectedPhotos, String.valueOf(i)), "class")
							.equals("disbl")) {
				hover(parameterizedLocator(eleSelectedPhotosTitle, String.valueOf(i)));
				break;
			}
		}
		return value;
	}

	/**
	 * This method will verify Disabled photosCheckbox Tooltip
	 * 
	 * @author himanshu.dua
	 * @param message
	 * @return
	 */
	public boolean verifyTooltipOnDisabledPhotosCheckboxes(String message) {
		int value = hoverOnDisabledCheckbox();
		flag = getAttribute(parameterizedLocator(eleSelectedPhotosTitle, String.valueOf(value)), "title")
				.equals(message);
		return flag;
	}

	/**
	 * This will verify the photos count on preview page
	 * 
	 * @param count
	 * @return
	 */
	public boolean verifyPhotoesCountOnPreview(int count) {
		int size = getElements(elePhotosCountOnPreview).size();
		if (size == count)
			flag = true;
		return flag;
	}

	/**
	 * This method will verify user is able to see added photos view on requirement
	 * preview page.
	 * 
	 * @author himanshu.dua
	 * @return
	 */
	public boolean verifyUserCanViewPhotoesOnPreviewPage() {
		int size = getElements(elePhotosCountOnPreview).size();
		for (int i = 1; i <= size; i++) {
			hover(parameterizedLocator(eleSelectedPhotosOnPreview, String.valueOf(i)));
			click(parameterizedLocator(elePhotosViewOnPreview, String.valueOf(i)));
			if (isDisplayed(elePhotoPreview)) {
				flag = true;
				click(elePhotoPreviewCloseIcon);
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * This function is used for select the first address.
	 * 
	 * @author himanshu.dua
	 */
	public void selectFirstAddress() {
		WebElement we = null;
		if(isDisplayed(eleAddress))
			we = getElement(eleAddress);
		else if(isDisplayed(eleAddressCL))
			we = getElement(eleAddressCL);
		Select select = new Select(we);
		select.selectByIndex(1);
	}

	/**
	 * It will select the educational option
	 * 
	 * @author himanshu.dua
	 * @param option
	 */
	public void selectEducationalOption(String option) {
		if (option.contains("Doctorate"))
			click(parameterizedLocator(eleEducationDoctorateOption, option));
		else
			click(parameterizedLocator(eleEducationgradicationOption, option));
	}

	/**
	 * This method will select Educational Course & Subject
	 * 
	 * @param option
	 * @param course
	 * @param subject
	 */
	public void educationalCourseAndSubject(String option, String course, String subject) {
		String degree = "";
		if (option.contains("Doctorate"))
			degree = "ppg";
		else if (option.contains("Post"))
			degree = "pg";
		else if (option.contains("Graduation"))
			degree = "ug";
		click(parameterizedLocator(eleEducationCourse, degree, course));
		click(parameterizedLocator(eleEducationSubject, degree, subject));
	}

	/**
	 * This method will verify Graduation pop-up and its text
	 * 
	 * @author himanshu.dua
	 * @param message
	 * @return
	 */
	public boolean verifyGraducationNotRequiredPopUpandText(String message) {
		if (isDisplayed(confirmationPopup))
			flag = getText(confirmationPopupText).equals(message);
		return flag;
	}

	/**
	 * This method will click on continue button on Graduation pop-up
	 * 
	 * @author himanshu.dua
	 */
	public void clickOnContinueBtnOnGraducationNotRequiredPopUp() {
		click(eleContinueBtn);
	}

	/**
	 * This method verify post graduation and doctorate degree disabled if
	 * graduation disabled
	 * 
	 * @param degree, tooltip
	 * @return
	 */
	public boolean verifyPostgraduationAndDoctorateDisabled(String degree, String tooltip) {
		return getAttribute(parameterizedLocator(eleDegree, degree), "title").equals(tooltip);
	}

	/**
	 * This method verify post graduation and doctorate degree disabled if
	 * graduation disabled
	 * 
	 * @param degree, tooltip
	 * @return
	 */
	public boolean verifyPostgraduationAndDoctorateEnabled(String degree, String tooltip) {
		return !getAttribute(parameterizedLocator(eleDegree, degree), "title").equals(tooltip);
	}

	/**
	 * This method verify education specialization
	 * 
	 * @param type
	 * @param value
	 * @return
	 */
	public boolean verifyEducationSpecializations(String type, String value) {
		if (type.equalsIgnoreCase("first"))
			flag = getText(parameterizedLocator(eleEducationSpecializations, "1")).equals(value);
		else if (type.equalsIgnoreCase("second"))
			flag = getText(parameterizedLocator(eleEducationSpecializations, "2")).equals(value);
		return flag;
	}

	/**
	 * This method verify default education specialization
	 * 
	 * @param value
	 * @return
	 */
	public boolean verifyDefaultEducationSpecializations(String value) {
		return getText(eleDefaultEducationSpecializations).equals(value);
	}

	/**
	 * Verify First option in education specialization is selected by default.
	 * 
	 * @return
	 */
	public boolean verifyFirstOptionIsSelected() {
		return isSelected(parameterizedLocator(eleEducationSpecializationsInput, "1"));
	}

	/**
	 * This method verify Default education specializations is not displaying if
	 * only one specializations is selected
	 * 
	 * @return
	 */
	public boolean verifyDefaultEducationSpecializationsIsDisplaying() {
		return isDisplayed(eleDefaultEducationSpecializations);
	}

	/**
	 * This method will click on cancel link on continue popup
	 */
	public void clickOnCancelLinkOnContinuePopup() {
		click(eleCancelLinkOnContinuePopup);
	}

	/**
	 * This method will click on close link on continue popup
	 */
	public void clickOnCloseLinkOnContinuePopup() {
		click(eleCloseLinkOnContinuePopup);
	}
	
	/**
	 * This method will verify the walking start date field is displaying.
	 * @return
	 */
	public boolean verifyWalkinStartDateDisplaying() {
		return isDisplayed(eleWalkinStartDate);
	}
	
	/**
	 * This method will verify walking start date is mandatory or not 
	 * @return
	 */
	public boolean verifyWalkinStartDateIsMandatory() {
		return isDisplayed(eleWalkinStartDateMadatory);
	}
	
	/**
	 * This method will verify the walkin Hint text
	 * @param placeholder
	 * @return
	 */
	public boolean verifyWalkinStartDateHintText(String placeholder) {
		return getAttribute(eleWalkinStartDate,"placeholder").trim().equals(placeholder);
	}
	
	/**
	 * This method will verify walkin error message and it's message
	 * @param errorMessage
	 * @return
	 */
	public boolean verifyWalkinStartDateErrorIsDisplaying(String errorMessage) {
		return isDisplayed(eleWalkinStartDateError) && getText(eleWalkinStartDateError).trim().equals(errorMessage);
	}
	
	/**
	 * This method will verify previous date is disabled
	 * @return
	 */
	public boolean verifyPreviousDateDisabled() {
		if (isDisplayed(eleWalkinStartDatePreviousCalendarDate))
			flag = getAttribute(eleWalkinStartDatePreviousCalendarDate, "class").trim().equals("disable");
		else if (isDisplayed(eleWalkinStartDatePreviousCalendarDateTotal)) {
			int size = getElements(eleWalkinStartDatePreviousCalendarDateTotal).size();
			for (int i = 1; i <= size; i++) {
				if (!getAttribute(parameterizedLocator(eleWalkinStartDatePreviousCalendarDate2, String.valueOf(i)),
						"class").trim().equals("disable")) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * This method will select the next day on the calendar
	 * @return
	 */
	public String selectAnyNextDate() {
		String date="";
		if (isDisplayed(eleWalkinStartDateNextCalendarDate)) {
			date=getText(eleWalkinStartDateNextCalendarDate);
			click(eleWalkinStartDateNextCalendarDate);
		}
		else if (isDisplayed(eleWalkinStartDateNextCalendarDate2)) {
			date=getText(eleWalkinStartDateNextCalendarDate2);
			click(eleWalkinStartDateNextCalendarDate2);
		}
		return date;
	}
	
	/**
	 * This method will click on the wealkin calendar
	 */
	public void clickOnWalkinCalendar() {
		click(eleWalkinStartDateCalendar);
	}
	
	/**
	 * This method verify the walking duration text
	 * @param selectedDate
	 * @param text
	 * @return
	 */
	public boolean verifyWalkingDurationText(String selectedDate, String durationDays, String text) {
		
		String expectedText = "", toDate="";
		String[] month;
		int monthValue=1, monthValueTo;
		int toYear;
		clickOnWalkinCalendar();
		month = getText(eleWalkinDurationMonth).split(" ");
		String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		for (String i : monthNames) {
			if (i.equals(month[0]))
				break;
			monthValue++;
		}
		monthValueTo=monthValue;
		toYear=Integer.valueOf(month[1]);
		if(selectedDate.equals("30") && monthValue==1||selectedDate.equals("30") && monthValue==3||selectedDate.equals("30") && monthValue==5||selectedDate.equals("30") && monthValue==7 ||selectedDate.equals("30") && monthValue==8 ||selectedDate.equals("30") && monthValue==10 ||selectedDate.equals("30") &&monthValue==12)
			toDate="31";
		else if(selectedDate.equals("28") && monthValue==2|| selectedDate.equals("29") && monthValue==2) {
			if(Integer.valueOf(month[1])%4==0 && selectedDate.equals("28"))
				toDate="29";
			else {
				toDate="1";
				monthValueTo+=1;
			}
		}
		else if (selectedDate.equals("30")&& monthValue==4||selectedDate.equals("30")&& monthValue==6||selectedDate.equals("30")&& monthValue==9||selectedDate.equals("30")&& monthValue==11) {
			toDate="1";
			monthValueTo+=1;
		}
		else if (selectedDate.equals("31") && monthValue==1||selectedDate.equals("31") && monthValue==3||selectedDate.equals("31") && monthValue==5||selectedDate.equals("31") && monthValue==7 ||selectedDate.equals("31") && monthValue==8 ||selectedDate.equals("31") && monthValue==10) {
			toDate="1";
			monthValueTo+=1;
		}
		else if (selectedDate.equals("31") && monthValue==12) {
			toDate="1";
			monthValueTo=1;
			toYear+=1;
		}
		else
			toDate=String.valueOf(Integer.valueOf(selectedDate)+(Integer.valueOf(durationDays)-1));
		expectedText = "Walk-in from " + selectedDate + "-" + monthValue + "-" + month[1] + " to " +toDate+ "-" + monthValueTo + "-" + toYear +" "+ text;
		return isDisplayed(eleWalkinDurationText) && getText(eleWalkinDurationText).trim().equals(expectedText);
	}
	
	/**
	 * This method will verify Duration DD.
	 * @return
	 */
	public boolean verifyDurationDD() {
		return isDisplayed(eleWalkinDurationField);
	}
	
	/**
	 * This method will verify Duration DD Default value
	 * @param defaultValue
	 * @return
	 */
	public boolean verifyDurationDDDefaultValue(int defaultValue) {
		System.out.println("-->>> "+getAttribute(eleWalkinDurationDefaultValue, "value"));
		return getAttribute(eleWalkinDurationDefaultValue, "value").equals(String.valueOf(defaultValue));
	}
	
	/**
	 * This function verify duration DD value.
	 * @return
	 */
	public boolean verifyDurationDdValues(int started, int end) {
		boolean flag=true;
		click(eleWalkinDurationField);
		for (int i = started; i <= end; i++) {
			if (!isDisplayed(parameterizedLocator(eleWalkinDurationDdValue, String.valueOf(i)))) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * This method will click on the value on Duration DD.
	 * @param days
	 */
	public void selectDurationDays(String days) {
		click(eleWalkinDurationField);
		click(parameterizedLocator(eleWalkinDurationDdValue, String.valueOf(days)));
	}
	
	/**
	 * This method will verify walkin timing DD
	 * @return
	 */
	public boolean verifyWalkinTimeDdIsDisplaying() {
		return isDisplayed(eleWalkinStartTimeDD) && isDisplayed(eleWalkinEndTimeDD);
	}
	
	/**
	 * This method will verify default set timing
	 * @return
	 */
	public boolean verifyDefaultSetTiming() {
		return getAttribute(eleWalkinTimeDefault,"value").trim().equals("9.30 AM");
	}
	
	/**
	 * This method will verify the start time difference b/w two timings
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public boolean verifyStartTimeDifference() {
		boolean flag = true;
		click(eleWalkinStartTimeDD);
		int size = getElements(eleWalkinStartTimingTotal).size();
		for (int i = 1; i < size; i++) {
			if(i==10)
				continue;
			String[] currentTime = getText(parameterizedLocator(eleWalkinTimeStart, String.valueOf(i))).split(" ");
			String[] nextTime = getText(parameterizedLocator(eleWalkinTimeStart, String.valueOf(i + 1))).split(" ");
			if (!GenericFunctions.getTimeDifferenct(currentTime[0], nextTime[0]).equals("30")) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * This method will verify the End time difference b/w two timings
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public boolean verifyEndTimeDifference() {
		boolean flag = true;
		click(eleWalkinEndTimeDD);
		int size = getElements(eleWalkinEndTimingTotal).size();
		for (int i = 1; i < size; i++) {
			if(i==9)
				continue;
			String[] currentTime = getText(parameterizedLocator(eleWalkinTimeEnd, String.valueOf(i))).split(" ");
			String[] nextTime = getText(parameterizedLocator(eleWalkinTimeEnd, String.valueOf(i + 1))).split(" ");
			if (!GenericFunctions.getTimeDifferenct(currentTime[0], nextTime[0]).equals("30")) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * This method verify walkin timing Error message
	 * @return
	 */
	public boolean verifyWalkinTimeErrorMessage() {
		return isDisplayed(eleWalkinTimeError);
	}
	
	/**
	 *This method will select the start timing of walkin
	 * @param stratTime
	 */
	public void selectStartTime(String stratTime) {
		click(eleWalkinStartTimeDD);
		click(parameterizedLocator(eleWalkinTimeStartTiming, stratTime));
	}
	
	/**
	 *This method will select the end timing of walkin
	 * @param endTime
	 */
	public void selectEndTime( String endTime) {
		click(eleWalkinEndTimeDD);
		click(parameterizedLocator(eleWalkinTimeEndTiming, endTime));
	}
	
	/**
	 * This method will verify the contact person filed is present in walkin section.
	 * @return
	 */
	public boolean verifyWalkinContactPerson() {
		return isDisplayed(eleWalkinContactPerson);
	}
	
	/**
	 * 
	 * @param placeholder
	 * @return
	 */
	public boolean verifyWalkinContactPersonPlaceholder(String placeholder) {
		return getAttribute(eleWalkinContactPerson,"placeholder").equals(placeholder);
	}
	
	/**
	 * This method will verify the contact person filed is present in walkin section.
	 * @return
	 */
	public boolean verifyWalkinContactPersonErrorMessage(String message) {
		return isDisplayed(eleWalkinContactPersonError) && getText(eleWalkinContactPersonError).equals(message);
	}
	
	/**
	 * This method will verify the contact person number
	 * @return
	 */
	public boolean verifyWalkinContactPersonNumber() {
		return isDisplayed(eleWalkinContactNumber);
	}
	
	/**
	 * This method will verify contact person number placeholder
	 * @param placeholder
	 * @return
	 */
	public boolean verifyWalkinContactPersonNumberPlaceholder(String placeholder) {
		return getAttribute(eleWalkinContactNumber,"placeholder").equals(placeholder);
	}
	
	/**
	 * This method will verify the contact person number error
	 * @param message
	 * @return
	 */
	public boolean verifyWalkinContactPersonNumberErrorMessage(String message) {
		return isDisplayed(eleWalkinContactNumberError) && getText(eleWalkinContactNumberError).equals(message);
	}
	
	/**
	 * This will verify contact person filed is not mandatory
	 * @return
	 */
	public boolean verifyWalkinContactPersonMandatory() {
		if(!isDisplayed(eleWalkinContactPersonMandatory))
			flag= true;
		return flag;
	}
	
	/**
	 * This method will verify the contact number note 
	 * @return
	 */
	public boolean verifyWalkinContactNumberNoteIsDisplaying() {
		return isDisplayed(eleWalkinContactNumberNote);
	}
	
	/**
	 * This function is used for fill contact person name
	 * @param name
	 */
	public void enterContactPersonName(String name) {
		sendKeys(eleWalkinContactPerson, name);
	}
	
	/**
	 * This function is used for fill contact person Number
	 * @param name
	 */
	public void enterContactPersonNumber(String number) {
		sendKeys(eleWalkinContactNumber, number);
	}
	
	/**
	 * This will verify contact number filed is not mandatory
	 * @return
	 */
	public boolean verifyWalkinContactNumberMandatory() {
		if(!isDisplayed(eleWalkinContactNumberMandatory))
			flag= true;
		return flag;
	}
	
	/**
	 * This method will verify contact person number length
	 * @param number
	 * @return
	 */
	public boolean verifyWalkinContactPersonNumberlength() {
		return getAttribute(eleWalkinContactNumber,"value").length()==15;
	}
	
	/**
	 * This method will verify contact person number length
	 * @param number
	 * @return
	 */
	public boolean verifyWalkinContactPersonNumberIsSame(String number) {
		return getAttribute(eleWalkinContactNumber,"value").equals(number);
	}
	
	/**
	 * This method will verify the contact number field text is displaying 
	 * @return
	 */
	public boolean verifyWalkinContactPersonNumberTextIsDisplaying(String text) {
		return isDisplayed(eleWalkinContactPersonNumberText) && getText(eleWalkinContactPersonNumberText).contains(text);
	}
	
	/**
	 * This method will verify the contact person field text is displaying 
	 * @return
	 */
	public boolean verifyWalkinContactPersonTextIsDisplaying(String text) {
		return isDisplayed(eleWalkinContactPersonText) && getText(eleWalkinContactPersonText).contains(text);
	}
	
	/**
	 * This method will verify the walkin start time text is displaying
	 * @return
	 */
	public boolean verifyWalkinStartDateTextIsDisplaying(String text) {
		return isDisplayed(eleWalkinStartTimeText) && getText(eleWalkinStartTimeText).contains(text);
	}
	
	/**
	 * This method is verifying venue field is displaying
	 * @return
	 */
	public boolean verifyVenueFieldIsDisplaying() {
		return isDisplayed(eleWalkinVenueField);
	}
	
	/**
	 * This method is verify error message is displaying
	 * @return
	 */
	public boolean verifyVenueFieldErrorIsDisplaying(String message) {
		return isDisplayed(eleWalkinVenueFieldError) && getText(eleWalkinVenueFieldError).trim().equals(message);
	}
	
	/**
	 * This method is for verifying Venue field is mandatory
	 * @return
	 */
	public boolean verifyVenueFieldIsMandatory() {
		return isDisplayed(eleWalkinVenueMandatory);
	}
	
	/**
	 * This method will verify the venue field hint text
	 * @param hintText
	 * @return
	 */
	public boolean verifyWalkinVenueFieldHintText(String hintText) {
		return getAttribute(eleWalkinVenueField,"placeholder").trim().equals(hintText);
	}
	
	/**
	 * This method is for verifying Google field is displaying
	 * @return
	 */
	public boolean verifyGoogleUrlFieldIsDisplaying() {
		return isDisplayed(eleGoogleUrlField);
	}
	
	/**
	 * This method will enter value in google open field.
	 * @param url
	 */
	public void enterUrlInGoogleOpenField(String url) {
		sendKeys(eleGoogleUrlField, url);
	}
	
	/**
	 * This method will verify the google open field entered text
	 * @param text
	 * @return
	 */
	public boolean verifyGoogleOpenFieldValue(String text) {
		return getAttribute(eleGoogleUrlField, "value").trim().equals(text);
	}
	
	/**
	 * This method will verify the walkin start time text is displaying
	 * @return
	 */
	public boolean verifyGoogleOpenFieldTextIsDisplaying(String text) {
		return isDisplayed(eleGoogleOpenFieldText) && getText(eleGoogleOpenFieldText).contains(text);
	}
	
	/**
	 * This method is for verifying Google Link is displaying
	 * @return
	 */
	public boolean verifyGoogleUrlLinkIsDisplaying(String linkText) {
		return isDisplayed(eleGoogleUrlLink) && getText(eleGoogleUrlLink).equals(linkText);
	}
	
	/**
	 * This method is for verifying Google Link icon image is displaying
	 * @return
	 */
	public boolean verifyGoogleUrlLinkIconImageIsDisplaying() {
		return isDisplayed(eleGoogleUrlIcon);
	}
	
	/**
	 * This method is for verifying Google Link icon tool tip text is displaying
	 * @return
	 */
	public boolean verifyGoogleUrlLinkIconToolTipTextIsDisplaying(String text) {
		hover(eleGoogleUrlIcon);
		return isDisplayed(parameterizedLocator(eleGoogleUrlIconToolTipText, text));
	}
	
	/**
	 * This method is for verifying Google Link icon tool tip text is displaying
	 * @return
	 */
	public boolean verifyGoogleUrlLinkIconToolTipTextLinkIsDisplaying(String text) {
		hover(eleGoogleUrlIcon);
		return isDisplayed(parameterizedLocator(eleGoogleUrlIconToolTipLink, text));
	}
	
	/**
	 * This method is for verifying correct Google Link icon tool tip Link value is displaying
	 * @return
	 */
	public boolean verifyGoogleUrlLinkIconToolTipTextLinkValue(String text, String linkText) {
		hover(eleGoogleUrlIcon);
		return getAttribute(parameterizedLocator(eleGoogleUrlIconToolTipLink, text),"href").trim().equals(linkText);
	}
	
	/**
	 * This method will click on search google Link
	 */
	public void clickOnSearchGoogleLink() {
		click(eleGoogleUrlLink);
	}
	
	/**
	 * This method is for verifying Google location search layer is displaying
	 * @return
	 */
	public boolean verifyGoogleLocationLayerIsDisplaying() {
		return isDisplayed(eleLocationLayer);
	}
	
	/**
	 * This method is for verifying Google location search layer is displaying
	 * @return
	 */
	public boolean verifyUseLocationBtnIsDisplayingOnGoogleLocationLayer() {
		return isDisplayed(eleUseLocationOnLocationLayer);
	}
	
	/**
	 * This method will verify selected Employment value
	 * @return
	 */
	public boolean selectedEmplyementValue(String empType) {
		return getAttribute(eleEmploymentType, "value").equals(empType);
	}
	
	/**
	 * This method is for verifying Variable field is not displaying on req details page
	 * @return
	 */
	public boolean verifyVariableFieldIsNotDisplayingOnReqDetailsPage() {
		return !isDisplayed(eleVariableFieldValueOnRequirementDetailsPage);
	}
	
	/**
	 * This method is for verifying Google location search layer is displaying
	 * @return
	 */
	public boolean verifywalkinDateLabelIsDisplaying(String label) {
		return isDisplayed(parameterizedLocator(eleWalkinDateFieldLabel,label));
	}
	
	/**
	 * This function will select the first option in the location list on google layer
	 */
	public void selectFirstGoogleLocationOption() {
		click(eleSearchOnLocationLayer);
		click(eleFirstGoogleLocationOption);
	}
	
	/**
	 * This function will click on the use this location button
	 */
	public void clickOnUseThisLocationBtn() {
		click(eleUseLocationOnLocationLayer);
	}
	
	/**
	 * This method will verify the search value is same as entered in Venue field
	 * @param value
	 * @return
	 */
	public boolean verifylocationSearchValueOnGoogleLayer(String value) {
		return getAttribute(eleSearchOnLocationLayer,"value").equals(value);
	}
	
	/**
	 *This function is used for verify contact phone number text field is not displaying
	 * 
	 * @return
	 */
	public boolean verifyContactPhoneNumberTextIsNotDisplayed() {
		return !isDisplayed(eleContactPhoneText);
	}
	
	/**
	 * This method will select the walkin start and end time 
	 * @param startTime
	 * @param endTime
	 */
	public void selectWalkinStartOrEndTime(String startTime, String endTime) {
		click(eleWalkinStartTimeDD);
		click(parameterizedLocator(eleWalkinTimeStartTiming, startTime));
		click(eleWalkinEndTimeDD);
		click(parameterizedLocator(eleWalkinTimeEndTiming,endTime));
	}
	
	/**
	 * This method will verify the walkin value on Requirement details page
	 * @param value
	 * @return
	 */
	public boolean verifyWalkinDetailsOnReqDetailsPage(String value) {
		return isDisplayed(parameterizedLocator(eleWalkinDetailOnReqDetailsPage,value));
	}
	
	/**
	 *This function is used for verify venue address DD field is displaying
	 * 
	 * @return
	 */
	public boolean verifyVenueAddressDdIsDisplayed() {
		return isDisplayed(eleVenueAddressDD);
	}
	
	/**
	 * This method will be used for verify saved address list is displaying or not
	 * @return
	 */
	public boolean verifySavedAddressList() {
		return isDisplayed(eleVenueSavedAddressList);
	}
	
	/**
	 * This method will be used for click on saved address list in venue field
	 * @return
	 */
	public void clickOnVenueAddressListDd() {
		click(eleVenueAddressDD);
	}
	
	/**
	 * This method will enter value in venue field
	 * @param venue
	 */
	public void enterLocationInVenue(String venue) {
		sendKeys(eleWalkinVenueField, venue);
	}
	
	/**
	 * This method will verify walkin details on preview page
	 * @param walkinDetail
	 * @return
	 */
	public boolean verifyWalkinDetailOnPreviewPage(String walkinDetail) {
		return isDisplayed(parameterizedLocator(eleWalkinDetailOnPreviewPage, walkinDetail));
	}
	
	/**
	 * This method will be used for verify Add video link is displaying or not
	 * @return
	 */
	public boolean verifyAddVideoLinkIsPresent(String link) {
		return isDisplayed(parameterizedLocator(eleAddVideoLink,link));
	}
	
	/**
	 * This method will be used for verify Add video link is displaying as non mandatory
	 * @return
	 */
	public boolean verifyAddVideoLinkIsNonMandatory() {
		return !isDisplayed(eleAddVideoLinkMandatory);
	}
	
	/**
	 * This method will be used for verify Add video link is displaying after presentation field
	 * @return
	 */
	public boolean verifyAddVideoLinkAfterPresentaion(String field) {
		return isDisplayed(parameterizedLocator(elePresentationBeforeVeido,field));
	}
	
	/**
	 * This method will be used for verify Add video drop down is displaying or not
	 * @return
	 */
	public boolean verifyAddVideoDdIsPresent() {
		return isDisplayed(eleAddVideoDD);
	}
	
	/**
	 * This method will click on Add video URL
	 */
	public void clickOnAddVideoDD() {
		wait.waitForProcessingToDisappear(10, 3);
		click(eleAddVideoDD);
	}
	
	/**
	 * This method will verify total added videos are displaying or not
	 * @param expectedCount
	 * @return
	 */
	public boolean verifyTotalAddedVideo(int expectedCount) {
		return getElements(eleTotalAddedVideo).size()==expectedCount;
	}
	
	/**
	 * This method will click on first video from list
	 */
	public String selectFirstVideoFromList() {
		click(eleFirstVideo);
		return getText(eleFirstVideo);
	}
	
	/**
	 * This method will be used for verify Added video thumbnail
	 */
	public boolean verifyAddedVideoThumbnail() {
		return isDisplayed(eleVideoThumbnail);
	}
	
	/**
	 * This method will beclick on Added video thumbnail
	 */
	public void clickOnVideoThumbnail() {
		click(eleVideoThumbnail);
	}
	
	/**
	 * This method will be used for verify video playing after clicking on thumbnail
	 */
	public boolean verifyVideoPlayingAfterClickOnThumbnail(String expectedUrl) {
		return getCurrentURL().contains(expectedUrl);
	}
	
	/**
	 * This method will remove the selected video from list
	 */
	public void RemoveSelectedVideo() {
		getElement(eleAddVideoDD).clear();
		click(parameterizedLocator(eleVideoUrlLabel, "Add Video URL"));
	}
	
	/**
	 * This method will verify added video yrl field label
	 * @param label
	 * @return
	 */
	public boolean verifyAddedVideoUrlLabel(String label) {
		return isDisplayed(parameterizedLocator(eleVideoUrlLabel, label));
	}
	
	/**
	 *	This method will verify  
	 * @param url
	 * @return
	 */
	public boolean verifyRedirectNaukriVideoAddedURL(String url) {
		return getCurrentURL().contains(url);
	}
	
	/**
	 * This method will verify refresh link link is displaying or not
	 * @param field
	 * @param link
	 * @return
	 */
	public boolean verifyRefreshListLink(String field, String link) {
		return isDisplayed(parameterizedLocator(eleRefreshList, field, link));
	}
	
	/**
	 * This method will click on the refresh link
	 * @param field
	 * @param link
	 */
	public void clickOnRefreshLinkAgainstField(String field, String link) {
		click(parameterizedLocator(eleRefreshList, field, link));
	}
	
	/**
	 * This method will verify media on preview is displaying
	 * @param type
	 * @param total
	 * @return
	 */
	public boolean verifyMediaOnPreview(String type) {
		return getElements(parameterizedLocator(eleMediaOnPreview, type)).size()==1;
	}
	
	/**
	 * This function will verify view and download text on media
	 * @param type
	 * @param text
	 * @return
	 */
	public boolean verifyViewAndDownloadTextOnMediaHover(String type, String text) {
		hover(parameterizedLocator(eleMediaOnPreview, type));
		return isDisplayed(parameterizedLocator(eleMediaViewDownloadOnPreview, type, text));
	}
	
	/**
	 * This method will used for clicking on media view and download text
	 * @param type
	 * @param text
	 */
	public void clickOnViewAndDownloadTextOnMediaFromPreviewPage(String type) {
		click(parameterizedLocator(eleMediaOnPreview, type));
	}
	
	/**
	 * This method will verify the Job description values on preview
	 * @param fieldName
	 * @return
	 */
	public boolean verifyJdValuesOnPreview(String fieldName, String value) {
		if(fieldName.contains("Roles"))
			flag=getText(parameterizedLocator(eleJobDescriptionRolesAndResponsibilityOnPreview, fieldName)).contains(value);
		else
			flag=getText(parameterizedLocator(eleJobDescriptionValuesOnPreview, fieldName)).contains(value);
		return flag;
	}
	
	/**
	 * This method will verify the Job description fields on preview
	 * @param fieldName
	 * @return
	 */
	public boolean verifyJDFieldsAreDisplaying(String fieldName) {
		return isDisplayed(parameterizedLocator(eleJobDescriptionOnPreview, fieldName));
	}
	
	/**
	 * This method will verify the Job description values on preview
	 * @param fieldName
	 * @return
	 */
	public boolean verifyJdValuesOnPreviewForClassified(String fieldName, String value) {
		if (fieldName.contains("Other"))
			flag = getText(parameterizedLocator(eleOtherSalryValuesOnPreviewForClassified, fieldName)).contains(value);
		else
			flag = getText(parameterizedLocator(eleJobDescriptionValuesOnPreviewForClassified, fieldName))
					.contains(value);
		return flag;
	}
	
	/**
	 * This method will verify the CL job description and candidate profile value in edit mode 
	 * @param field
	 * @param value
	 * @return
	 */
	public boolean verifyCLJobEditorValues(String field, String value) {
		if(field.contains("Description"))
			flag=getText(parameterizedLocator(eleCLJobEditor, "description")).contains(value);
		else if(field.contains("Candidate"))
			if(!isDisplayed(parameterizedLocator(eleCLJobEditor, "candidateProfile")))
				click(fillCandidateDetails);
			flag=getText(parameterizedLocator(eleCLJobEditor, "candidateProfile")).contains(value);
		return flag;
	}
	
	public void removeCandidateDetails() {
		switchToFrame(candidateDetailsEditor);
		getElement(By.tagName("body")).clear();
		switchToDefaultContent();
	}
	
	public void removeMoreSalaryDetails(String migrationStatus) {
		if (migrationStatus.equals("JP migrated")) {
			switchToFrame(otherSalaryDetails);
			getElement(By.tagName("body")).clear();
			switchToDefaultContent();
		} else {
			getElement(eleOtherSalaryNonMigrated).clear();
		}
		TestNGLogUtility.info("other salary details as " + otherSalaryDetailsText);
	}

	/**
	 * Click on Next button on Requirement edit page
	 */
	public void clickOnNextBtn() {
		click(eleNextBtn);
	}
	
	/**
	 * This method will select the Education Specializations 
	 * @param index
	 */
	public void selectEducationSpecializations(String index) {
		click(parameterizedLocator(eleEducationSpecializationsInput, index));
	}
	
	/*
	 * To verify Requirement error message is displaying
	 * @author himanshu.dua
	 * @return
	 */
	public boolean presenceOferrorMessageOfRequirementCreationWithoutHmSpoc(String message) {
		wait.waitForProcessingToDisappear(10, 3);
		return getText(eleReqErrorMessageText).trim().equals(message);

	}
	public void jobLocationSelect()
	{
		click(locationDD);

	}
	public boolean verifyContentsOfJobLoc(String loc)
	{
		return isDisplayed(parameterizedLocator(eleLocationSelected,loc));
	}
	public void selectInternationalLocFromDD(String locations)
	{

		List<String> locationsList = Arrays.asList(locations.split(","));
		if(!isDisplayed(eleJobLocations)) {
			click(internationalJobLocations);
		for(String location : locationsList) {

			wait.hardWait(1);
			click(parameterizedLocator(internationalJobLocOption, location));
		}
		requirementDetails.put("IntJobLocations", locations);
	}
	}

	public boolean verifyNoLocPresentIntextbox()
	{
		return !isDisplayed(eleJobLocations);
	}

	public boolean verifyHeadigsONPrefillDD(String headingsOfPrefill)
	{
		String vals =jsUtil.executeJavascriptForJSVariables("(function(){var items = document.querySelectorAll('#reqDDTabs a');var labels = [];items.forEach(function (item){ labels.push(item.innerText)});return labels.join(',');})()");
			if(!headingsOfPrefill.contains(vals))
			{
				return false;
			}

		return true;
	}
	public boolean verifyGroupDDNOtDisplayed()
	{
		if(!isDisplayed(groupOrHiringFor))
		return true;
		else
			return false;
	}
	public void entersCityNameWithInternationalLoc(String intLocation, String city)
	{
		wait.waitForVisibilityOfElement(internationalLocationCheckbox);
		selectInternationalLocFromDD(intLocation);
		fillInOtherCountry(city);
	}
	public boolean VerifyEnteredInternationalLocAndCityName(String countryName,String city)
	{
		String ExpectedTextCountryAndcity = getText(eleCityInternationalLoc);
		String actualTextCOuntryAndcity = countryName + " " + city;
		return ExpectedTextCountryAndcity.equals(actualTextCOuntryAndcity);
	}
	public void clickOnSaveLoc()
	{
		click(parameterizedLocator(otherCountrySaveOrCancel, "Save"));
	}

	public static String fileSystemPathTillTestData() {
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testdata" + File.separator;
		return filePath;
	}
	public void getTotalCountOfGroups()
	{
	String groupCOunt =	getText(totalGroupCount).trim();
	ReadWritePropertyFile.setProperty("GroupCountInSystem", groupCOunt,
			fileSystemPathTillTestData() + "Data.properties");
	}
	public void clickOnCrossSelectionStages()
	{
		click(eleCancelSelectionStage);
	}
	public void clickOnGroupsSelection()
	{
		click(groupOrHiringFor);
	}
	public boolean verifyHiringforReqPage(String hiringFOr)
	{
		return isDisplayed(parameterizedLocator(eleHiringForOnReqPage,hiringFOr));
	}
	public boolean verifyCountOfGroups()
	{
		String groupCountInSystem = ReadWritePropertyFile.getProperty("GroupCountInSystem",
				fileSystemPathTillTestData() + "Data.properties");
		int groupCOuntONReq = getElements(groupCount).size();
		String groupCountOnReqCreation = Integer.toString(groupCOuntONReq);
		return groupCountInSystem.equals(groupCountOnReqCreation);
	}
	
	public boolean verifyRecruiterNameOnReqCreation(String ExpectedRecruiterName)
	{
		click(recruiterName);
		return getText(recruiterNameDD).contains(ExpectedRecruiterName);
	}
	public boolean verifyHMOnReqCreation(String Expectedhm)
	{
		return getText(HmOnDD).contains(Expectedhm);
	}
	public void clickOnMaxExpDD()
	{
		wait.waitForElementToBeClickable(maxExp);
		click(maxExp);
	}
	public boolean verifyCountOfWkExp(String countExpected)
	{
		int countExpectedInINt = Integer.parseInt(countExpected);
		return getElements(workMaxExpSize).size()==countExpectedInINt;
	}
	public void UserEntersNoOfVacancies(String vacancy)
	{
		wait.waitForElementToBeClickable(vacancyCheck);
		click(vacancyCheck);
		sendKeys(vacancyField, vacancy);
	}
	public void userEntersRefCode(String refCode)
	{
		wait.waitForElementToBeClickable(addReferenceCode);
		click(addReferenceCode);
		sendKeys(addReferenceCodeField,refCode);
	}
	public boolean verifyUserVacancyAndRefCode(String vacancy , String vacancyNo , String ref, String refCode)
	{
		return getText(parameterizedLocator(elePreviewPageEnteredValues,vacancy)).equals(vacancyNo) &&
				getText(parameterizedLocator(elePreviewPageEnteredValues,ref)).equals(refCode);
	}
	public void selectFirstRequirementFromPrefillFromOtherReq()
	{
		click(eleFirstReqFromPrefillList);
	}
	public boolean verifyFieldsPrefilledFromPreviousReq()
	{
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(jobTitle);
		String currencyExpected="";

		WebElement currencyWe  = getElement(salaryCurrency);
		WebElement minSalWE  = getElement(minSalary);
		WebElement maxSalWE = getElement(maxSalary);
		WebElement minExperienceWE  = getElement(minExp);
		WebElement maxExperienceWE  = getElement(maxExp);


		Select selectCurrency = new Select(currencyWe);
		Select selectMinSalary = new Select(minSalWE);
		Select selectMaxSalary = new Select(maxSalWE);
		Select selectMinExp = new Select(minExperienceWE);
		Select selectMaxExp = new Select(maxExperienceWE);

		WebElement optionCurrency = selectCurrency.getFirstSelectedOption();
		WebElement optionMinSalary = selectMinSalary.getFirstSelectedOption();
		WebElement optionMaxSalary = selectMaxSalary.getFirstSelectedOption();
		WebElement optionMinExp = selectMinExp.getFirstSelectedOption();
		WebElement optionMaxExp = selectMaxExp.getFirstSelectedOption();

		String currencyDisplayed = optionCurrency.getText();
		if(currencyDisplayed.equals("US $"))
		{
			 currencyExpected = "USD";
		}
		String minSalaryDisplayed = optionMinSalary.getText();
		String maxSalaryDisplayed = optionMaxSalary.getText();
		String minExpDisplayed = optionMinExp.getText();
		String maxExpDisplayed = optionMaxExp.getText();
		String jobTitleExpected = getAttribute(jobTitle, "value");
		String jobDescExpected = getJobDescription();

		return	requirementDetails.get("jobDescription").equals(jobDescExpected) &&
		      jobTitleExpected.contains((String)(requirementDetails.get("jobTitle"))) &&
			  currencyExpected.contains((String) requirementDetails.get("currencyType")) &&
				minSalaryDisplayed.contains((String) requirementDetails.get("minCTC")) &&
				maxSalaryDisplayed.contains((String) requirementDetails.get("maxCTC")) &&
				minExpDisplayed.contains((String) requirementDetails.get("minExp")) &&
				maxExpDisplayed.contains((String) requirementDetails.get("maxExp")) ;
	}
	public String getJobDescription()
	{
		switchToFrame(jobDescription);
		String expectedJobDesc= getText(By.tagName("body"));
		switchToDefaultContent();
		return expectedJobDesc;

	}
	public boolean verifyHeadingOnRequirementCreation(String heading1,String heading2 , String heading3)
	{
		return isDisplayed(parameterizedLocator(eleReqHeading,heading1)) &&
				isDisplayed(parameterizedLocator(eleReqHeading,heading2)) &&
				isDisplayed(parameterizedLocator(eleReqHeading,heading3));
	}
	public void enterDuplicateReqName()
	{
		String duplicateReqName = (String) requirementDetails.get("requirementName");
		sendKeys(requirementTitle, duplicateReqName);
	}
	public void customFiltersChkbox()
	{
		click(chkCustomFilters);
	}
	public boolean verifyCurrencyPersistsOnEdit(String actualCurrency)
	{
		String currencyExpected="";
		WebElement currencyWe  = getElement(salaryCurrency);
		Select selectCurrency = new Select(currencyWe);
		WebElement optionCurrency = selectCurrency.getFirstSelectedOption();
		String currencyDisplayed = optionCurrency.getText();
		if(currencyDisplayed.equals("US $"))
		{
			currencyExpected = "USD";
		}
		else
		{
			currencyExpected = "Rs";
		}
			return currencyExpected.contains(actualCurrency);
	}
	public void selectOtherGroupOnReqCreationPage()
	{
		click(selectFirstGroupFrmDD);
	}

	public void userEntersWebsite(String companyWebsite)
	{
     sendKeys(eleCompanyWebsite,companyWebsite);
	}
	public void userEntersContactPerson(String contactPerson)
	{
		sendKeys(eleContactPerson,contactPerson);
	}
	public void enterPhoneNumber(String phoneNumber)
	{
		sendKeys(elePhoneNumber,phoneNumber);
	}

	public boolean verifyContactDetailsOnPreview(String companyWebSite, String contactPerson , String phoneNumber)
	{
		return getText(parameterizedLocator(eleContactDetails,"Contact Person")).contains(contactPerson) &
				getText(parameterizedLocator(eleContactDetails,"Phone")).contains(phoneNumber) &
				getText(parameterizedLocator(eleContactDetails,"Website")).contains(companyWebSite);

	}
	public boolean previewRequirement(String expectedText, String minExp, String maxExp, String keywords, String location)
	{
		return isDisplayed(parameterizedLocator(eleSalaryHolder,expectedText.replace("Annual CTC ", "").trim())) &&
		getText(parameterizedLocator(eleSalaryHolder,"Work Experience")).trim().contains(minExp +" to "+ maxExp) &&
		getText(parameterizedLocator(eleKeywordsPreview,"Keywords")).trim().contains(keywords) &&
		getText(parameterizedLocator(eleSalaryHolder,"Locations")).trim().contains(location);
		}

	public void clickOnAddNewQuestionaire()
	{
		wait.waitForVisibilityOfElement(eleAddNewQuestionaire);
		jsUtil.clickByJS(eleAddNewQuestionaire);
		wait.hardWait(2);
	}

	public boolean verifyQuestionLightboxDisplayed()
	{
		return isDisplayed(parameterizedLocator(questionnaireLightBoxTitle,"Add New Questionnaire"));
	}
	public void userEnterQuestionaireName()
	{
		String questionaireName = GenericFunctions.generateRandomStrings(6, "String");
		sendKeys(questionareName,questionaireName);
		ReadWritePropertyFile.setProperty("questionaireName",questionaireName,
				fileSystemPathTillTestData() + "Data.properties");
	}
	public void addNewQuestion()
	{
		click(eleAddNewQuestionbtn);
	}


	public boolean verifyQuestionaireName()
	{
			String questionaireNameExpected= ReadWritePropertyFile.getProperty("questionaireName",
				fileSystemPathTillTestData() + "Data.properties");
		String questionaireNameOnCreationPage = jsUtil.executeJavascriptForJSVariables("document.getElementById('inp_questionnairedd').value;");
		return questionaireNameOnCreationPage.contains(questionaireNameExpected);
	}
	public void enterQuestionAndSelectAnsOption(String option)
	{
		String questionAttached = GenericFunctions.generateRandomStrings(6, "String");
		ReadWritePropertyFile.setProperty("questionCreated",questionAttached,fileSystemPathTillTestData() + "Data.properties");
		sendKeys(eleQuestionOnLightbox,questionAttached);
		click(parameterizedLocator(eleAnsTypeQuestionaire,option));
	}
	public void enterQuestionOnEdit()
	{
		String questionAttached = GenericFunctions.generateRandomStrings(6, "String");
		ReadWritePropertyFile.setProperty("questionCreated",questionAttached,fileSystemPathTillTestData() + "Data.properties");
		sendKeys(eleQuestionOnLightbox,questionAttached);
		
	}
	public void enterTwoAnsToQuestionaire(String ans1, String ans2)
	{
		sendKeys(parameterizedLocator(eleAnswersQuestionaire,"1"),ans1);
		sendKeys(parameterizedLocator(eleAnswersQuestionaire,"2"),ans2);
	}
	public void enterThreeAnsToQuestionaire(String ans1, String ans2, String ans3)
	{
		click(parameterizedLocator(eleQuestionaireLightbox,"Add Another Answer Box"));
		sendKeys(parameterizedLocator(eleAnswersQuestionaire,"1"),ans1);
		sendKeys(parameterizedLocator(eleAnswersQuestionaire,"2"),ans2);
		sendKeys(parameterizedLocator(eleAnswersQuestionaire,"3"),ans3);
	}

	
	public void UserSaveQuestionOnQuestionaire()
	{
		click(eleSaveQuestion);
	}
	public void userClicksOnsaveQuestionaire()
	{
		wait.hardWait(2);
		click(btnSaveQuestionaire);
		wait.hardWait(2);
	}
	public boolean verifyErrorDisplayedOnQuestionaireName(String errorQuesName)
	{
		//return getText(errQuestionaireName).contains(errorQuesName);
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(errQuestionaireName, errorQuesName));
		//return errorQuesName.contains
	}
	public boolean verifyValidationForEmptyQues(String errorQues)
	{
		return getText(errQuestionName).contains(errorQues);
	}
	public boolean verifyValidationAnsName(String errorAns)
	{
		return getText(errAnsName).contains(errorAns);
	}
	public void userEntermaxNoOfAnsPossible()
	{
		int NoOfAnswersHidden =8;
		while(NoOfAnswersHidden!=0)
		{
		click(parameterizedLocator(eleQuestionaireLightbox,"Add Another Answer Box"));
		NoOfAnswersHidden--;
		}
	}
	public boolean verifyOnly10AnsCOuldBeDisplayed()
	{
		return isDisplayed(parameterizedLocator(eleQuestionaireLightbox,"Add Another Answer Box"));
	}
	public void cancelOnQuestionaireLightbox()
	{
		click(eleCancelLightbox);
		wait.waitForPageToLoadCompletely();
	}
	public void userClicksonMandatoryQuestion()
	{
		click(chkMandatoryQues);
	}
	public void userClicksOnOptionOnQuestionType(String option)
	{
		click(parameterizedLocator(eleQuestionaireLightbox,option));
	}
	public boolean verifyMandatoryQuestionchecked()
	{
		return  String.valueOf(jsUtil.executeJavascriptForJSVariables("document.getElementById('mandatory').checked.toString()")).contains("true");
	}
	public boolean verifyQuestionDisplayedOnEdit()
	{
		String expectedQuestionDisplayed = ReadWritePropertyFile.getProperty("questionCreated",fileSystemPathTillTestData() + "Data.properties");
		String actualQuestion =jsUtil.executeJavascriptForJSVariables("document.getElementById('question_name').value;");
		return actualQuestion.contains(expectedQuestionDisplayed);
		}
		public void changeTheQuestionOnEdit()
		{
			String questionAttachedOnEdit = GenericFunctions.generateRandomStrings(6, "String");
			ReadWritePropertyFile.setProperty("questionCreated",questionAttachedOnEdit,fileSystemPathTillTestData() + "Data.properties");
			sendKeys(eleQuestionOnLightbox,questionAttachedOnEdit);
		}
		public void updateJobTitleOfReq()
		{
			clearField(jobTitle);
			String jobTitle = "Updated Job Title";
			sendKeys(this.jobTitle, jobTitle);
			requirementDetails.put("jobTitle", jobTitle);
		}
		public void selectSUbrecruiterFromDD(String subRec)
		{
			wait.waitForVisibilityOfElement(recruiterName);
			click(recruiterName);
	
			wait.waitForVisibilityOfElement(parameterizedLocator(recruiterNameSelectByText,subRec));
			click(parameterizedLocator(recruiterNameSelectByText,subRec));

		}


	/**
	 * To check the count of the job being posted on requirement overview page is only 1
	 * @author avani
	 * @param nameOfJobPosted
	 * @return true if count is equal to one else false
	 */
	public boolean verifySingleJobIsBeingPostedRequirementOverviewPage(String nameOfJobPosted){
		List<WebElement> countOfJobPosted=getElements(parameterizedLocator(countOfJob,nameOfJobPosted));
		if(countOfJobPosted.size()==1){
			return true;}else{
			return false;}
	}
	
	/**
	 * This method is verify variable amount on preview page
	 * 
	 * @return
	 */
	public boolean verifyVariableValueOnReqisitionPreviewPage(String variable) {
		return isDisplayed(parameterizedLocator(eleVariableAmountOnPreview,variable));
	}
	
	/**
	 * This method will verify the Job description values on preview
	 * @param fieldName
	 * @return
	 */
	public boolean verifyJdFieldOnPreviewForClassified(String fieldName) {
		if (fieldName.contains("Other"))
			flag = isDisplayed(parameterizedLocator(eleOtherSalryValuesOnPreviewForClassified, fieldName));
		else
			flag = isDisplayed(parameterizedLocator(eleJobDescriptionValuesOnPreviewForClassified, fieldName));
		return flag;
	}
	
	/**
	 * This method will click on the Cancel button on Update Job pop-up
	 */
	public void clickOnCancelButtonOnUpdatePopup() {
		if(isDisplayed(eleUpdateJobPopup))
			click(eleCancelUpdateJob);
	}
	
	/**
	 * This method will verify added video yrl field label
	 * @param label
	 * @return
	 */
	public boolean verifyVideoUrlDdValue() {
		return isDisplayed(eleFirstVideo);
	}
	
	/**
	 * This method will verify walkin field label on Preview
	 * @param filedName
	 * @return
	 */
	public boolean verifyWalkinFieldOnPreview(String filedName) {
		return isDisplayed(parameterizedLocator(eleWalkinDetailsOnPreview, filedName));
	}
	
	/**
	 * This method will verify walkin field label on Preview
	 * @param filedName
	 * @return
	 */
	public boolean verifyWalkinValueOnPreview(String value) {
		return isDisplayed(parameterizedLocator(eleWalkinDetailsValueOnPreview, value));
	}
	
	/**
	 * This method is verify keyskill on requisition preview page
	 * 
	 * @return
	 */
	public boolean verifyKeyskillValueOnReqisitionPreviewPage(String keyskill) {
		return isDisplayed(parameterizedLocator(eleKeySkillOnRequisitionPreview,keyskill));
	}
	
	/**
	 * This method is verify error message for contact details
	 * 
	 * @return
	 */
	public boolean verifyErrorMessageForContactDetails(String msg) {
		return isDisplayed(parameterizedLocator(eleErrorMessageForContactDetailsField,msg));
	}
	
	public void clearComapnyText() {
		getElement(companyName_txt).clear();
	}
	
	public void clearAboutCompanyText() {
			switchToFrame(aboutCompany_iframe);
			getElement(By.tagName("body")).clear();
			switchToDefaultContent();
	}

	public boolean verifyRedirectedOverviewPageAfterequisitionRaised()
	{
		return (isDisplayed(requirementPlaceholderOnOverview)
				&& isDisplayed(parameterizedLocator(requirementNamePlaceHolder,PropFileHandler.readProperty("requirementNameCreatedAfterRequisition"))));

	}
	public void userUpdatesFirstpageOfRequirement()
	{
		updateJobTitleOfReq();
	}
	public boolean verifyResponseFilterTabActive()
	{
		return getText(eleResponseFiltertab).contains("Response Filters (Optional)");
	}
	public void clickOnSaveTab3()
	{
		scrollToElement(eleSaveProjectTab3);
		click(eleSaveProjectTab3);
	}
}

