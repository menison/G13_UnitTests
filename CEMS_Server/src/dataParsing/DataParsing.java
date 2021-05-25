package dataParsing;

import common.Permission;
import entities.Message;
import server.EchoServer;

import sql.GetExistsOrders;
import sql.GetChangeList;
import sql.GetLogin;
import sql.GetNewFamily;
import sql.GetNewGuide;
import sql.GetOrder;
import sql.GetReport;
import sql.OrderCancel;

/**
 * A function that includes all the cases in which 
 * a message is sent between the client and the server
 *
 */
public class DataParsing {

	public static Message Start(Object msg) {
		Message receivedMessage;
		if (msg instanceof Message)
			receivedMessage = (Message) msg;
		else {
			EchoServer.SC.addToTextArea("Cant Cast msg");
			return null;
		}
		switch (receivedMessage.getOperationType()) {
		case WorkerLogin:
			return GetLogin.WorkerLoginData(receivedMessage);

		case VisitorLogin:
			return GetLogin.VisitorLoginData(receivedMessage);

		case CancellationReport:
			return GetReport.CancellationReportData(receivedMessage);

		case VisitorReport:
			return GetReport.VisitorReportData(receivedMessage);

		case TotalVisitorReport:
			return GetReport.TotalVisitorReportData(receivedMessage);

		case UsageReport:
			return GetReport.UsageReportData(receivedMessage);

		case MonthlyIncomeReport:
			return GetReport.MonthlyIncomeData(receivedMessage);

		case GetPark:
			return GetOrder.GetPark(receivedMessage);

		case addNewGuide:
			return GetNewGuide.NewGuideData(receivedMessage);

		case addNewFamily:
			return GetNewFamily.NewFamilyData(receivedMessage);
		case GetAllParksName:
			return GetOrder.GetAllParkNames();
		case SetChangInPark:
			return GetChangeList.SetList(receivedMessage);
		case GetChangInPark:
			return GetChangeList.GetList(receivedMessage);
		case ApplyChangInPark:
			return GetChangeList.ApplyList(receivedMessage);
		case DeleteChangInPark:
			return GetChangeList.DeleteList(receivedMessage);
		case OrderTimeValidation:
			return GetOrder.PreOrderTimeValidation(receivedMessage);

		case getDiscountOfPark:
			return GetOrder.GetDiscountOfPark(receivedMessage);

		case AlternativeDates:
			return GetOrder.GetAlternativeDates(receivedMessage);

		case GetWaitingListIndex:
			return GetOrder.GetWaitingListIndex(receivedMessage);

		case NewOrder:
			return GetOrder.SetNewOrder(receivedMessage);

		case existsOrders:
			return GetExistsOrders.OrdersData(receivedMessage);

		case OrdersInWaitingList:
			return GetExistsOrders.OrdersInWaitingListData(receivedMessage);

		case CancelOrderByUser:
			return OrderCancel.CancelOrder(receivedMessage);

		case CancelOrderFromWaitingList:
			return OrderCancel.CancelOrderFromWaitingList(receivedMessage);

		case ExitFromWaitingListApproval:
			return GetOrder.GetOrderOutFromWaitingList(receivedMessage);

		case ApprovedOrder:
			return GetOrder.ApprovedOrder(receivedMessage);

		case AllOrdersMonth:
			return GetReport.getAllMonthFromOrders(receivedMessage);
			
		case AllOrdersMonthCancellation:
			return GetReport.getAllOrdersMonthCancellation(receivedMessage);
		
		case VisitorPerDateReport:
			return GetReport.getVisitorPerDateReport(receivedMessage);

		case OrderTimeValidationNotPreOrder:
			return GetOrder.OrderTimeValidation(receivedMessage);
			
			
		case SpecificNumberOfVisitors:
			return GetVisitors.GetSpecificNumberOfVisitors(receivedMessage);
			
		case SubNumberLogin:
			return GetLogin.SubLoginData(receivedMessage);

		case OrdersById:
			return GetOrder.GetOrdersById(receivedMessage);
		case SetNewStatusOrder:
			return GetOrder.SetNewStatusOrder(receivedMessage);
		case NumberOfVisitors:
			return GetVisitors.GetNumberOfVisitors(receivedMessage);
		case LoggedOut:
			return GetLogin.logOut(receivedMessage);


		default:
			break;
		}
		return null;
	}

	/**set the permission for account 
	 * @param password1
	 * @param password2
	 * @return if password1 equals password2 true else false 
	 */
	public static Permission getPermission(String password1, String password2) {
		return password1.equals(password2) ? Permission.yes : Permission.no;
	}

}
