package dataParsing;

import entities.Message;

public class Parsing {
	/**
	 * @param This class receives all types of messages resulting from clicks in the
	 *             system and routes them to the appropriate action for each of
	 *             them.
	 */
	public static void Message(Message receivedMessage) {

		switch (receivedMessage.getOperationType()) {

		case WorkerLogin:
			Login.resiveWorkerLogin(receivedMessage);
			break;

		case VisitorLogin:
			Login.resiveVisitorLogin(receivedMessage);
			break;

		case CancellationReport:
			report.resiveCancellationReport(receivedMessage);
			break;

		case VisitorReport:
			report.resiveTotalVisitorReport(receivedMessage);
			break;

		case TotalVisitorReport:
			report.resiveTotalVisitorReport(receivedMessage);

			break;

		case UsageReport:
			report.resiveUsageReport(receivedMessage);
			break;

		case GetAllParksName:
			Order.setParksFromServer(receivedMessage);
			break;

		case GetPark:
			Order.setParkObjFromServer(receivedMessage);
			break;

		case OrderTimeValidation:
			Order.receivedTimeValidation(receivedMessage);
			break;

		case OrderTimeValidationNotPreOrder:
			Order.receivedTimeValidationNotPreOrder(receivedMessage);
			break;

		case getDiscountOfPark:
			Order.setDiscountFromDataBase(receivedMessage);
			break;

		case AlternativeDates:
			Order.setAltDatesAndTimesFromServer(receivedMessage);
			break;

		case GetWaitingListIndex:
			Order.setWaitingListIndexFromServer(receivedMessage);
			break;

		case NewOrder:
			Order.newOrderSaved(receivedMessage);
			break;

		case existsOrders:
			ExistsOrders.recieveExistsOrders(receivedMessage);
			break;

		case OrdersInWaitingList:
			ExistsOrders.recieveOrdersInWaitingList(receivedMessage);
			break;

		case MonthlyIncomeReport:
			report.resiveMonthlyIncomeReport(receivedMessage);
			break;

		case addNewFamily:
			Registiration.recieveNewFamily(receivedMessage);
			break;

		case addNewGuide:
			Registiration.recieveNewGuide(receivedMessage);
			break;

		case SetChangInPark:
			ChangeInPark.resiveSetChangInPark(receivedMessage);
			break;

		case GetChangInPark:
			ChangeInPark.resiveGetChangInPark(receivedMessage);
			break;

		case ApplyChangInPark:
			ChangeInPark.resiveApplyChangInPark(receivedMessage);
			break;

		case DeleteChangInPark:
			ChangeInPark.resiveDeleteChangInPark(receivedMessage);
			break;

		case CancelOrderByUser:
			Order.OrderCanceled(receivedMessage);
			break;

		case ExitFromWaitingListApproval:
			Order.OrderGotOutFromWaitingList(receivedMessage);
			break;

		case ApprovedOrder:
			Order.OrderApproved(receivedMessage);
			break;

		case AllOrdersMonth:
			report.resiveAllMonthOfReports(receivedMessage);
			break;

		case AllOrdersMonthCancellation:
			report.resiveAllMonthOfCancellationReports(receivedMessage);
			break;

		case VisitorPerDateReport:
			report.resiveVisitorPerDateReport(receivedMessage);
			break;

			
		case SubNumberLogin:
			Login.resiveSubLogin(receivedMessage);
			break;
		case OrdersById:
			request.Order.SetOrdersByID(receivedMessage);
			break;

		case OrdersByIDAndStayTimePerOrder:
			request.Order.SetOrdersByIDAndStayTimePerOrder(receivedMessage);
			break;

		case SetNewStatusOrder:
			request.Order.changeStatusSuccessfull(receivedMessage);
			break;

		case NumberOfVisitors:
			Visitors.SetNumberOfVisitors(receivedMessage);

			break;

		case SpecificNumberOfVisitors:
			Visitors.SetSpecificNumberOfVisitors(receivedMessage);
			break;

		case Exitpark:
			request.Order.SetSuccessfull();

			 break;
			 
		case LoggedOut:
			Login.receivedLogOut(receivedMessage);
			break;

		default:
			break;
		}
	}