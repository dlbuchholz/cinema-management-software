/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CinemaManagementSoftwareFactoryImpl extends EFactoryImpl
		implements CinemaManagementSoftwareFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CinemaManagementSoftwareFactory init() {
		try {
			CinemaManagementSoftwareFactory theCinemaManagementSoftwareFactory = (CinemaManagementSoftwareFactory) EPackage.Registry.INSTANCE
					.getEFactory(CinemaManagementSoftwarePackage.eNS_URI);
			if (theCinemaManagementSoftwareFactory != null) {
				return theCinemaManagementSoftwareFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CinemaManagementSoftwareFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CinemaManagementSoftwareFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case CinemaManagementSoftwarePackage.CINEMA:
			return createCinema();
		case CinemaManagementSoftwarePackage.CUSTOMER:
			return createCustomer();
		case CinemaManagementSoftwarePackage.CINEMA_OWNER:
			return createCinemaOwner();
		case CinemaManagementSoftwarePackage.TICKET:
			return createTicket();
		case CinemaManagementSoftwarePackage.SCREENING:
			return createScreening();
		case CinemaManagementSoftwarePackage.MOVIE:
			return createMovie();
		case CinemaManagementSoftwarePackage.CINEMA_HALL:
			return createCinemaHall();
		case CinemaManagementSoftwarePackage.SEATING_ROW:
			return createSeatingRow();
		case CinemaManagementSoftwarePackage.SEAT:
			return createSeat();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case CinemaManagementSoftwarePackage.CATEGORY:
			return createCategoryFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '"
					+ eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case CinemaManagementSoftwarePackage.CATEGORY:
			return convertCategoryToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '"
					+ eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Cinema createCinema() {
		CinemaImpl cinema = new CinemaImpl();
		return cinema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Customer createCustomer() {
		CustomerImpl customer = new CustomerImpl();
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CinemaOwner createCinemaOwner() {
		CinemaOwnerImpl cinemaOwner = new CinemaOwnerImpl();
		return cinemaOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Ticket createTicket() {
		TicketImpl ticket = new TicketImpl();
		return ticket;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Screening createScreening() {
		ScreeningImpl screening = new ScreeningImpl();
		return screening;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Movie createMovie() {
		MovieImpl movie = new MovieImpl();
		return movie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CinemaHall createCinemaHall() {
		CinemaHallImpl cinemaHall = new CinemaHallImpl();
		return cinemaHall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SeatingRow createSeatingRow() {
		SeatingRowImpl seatingRow = new SeatingRowImpl();
		return seatingRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Seat createSeat() {
		SeatImpl seat = new SeatImpl();
		return seat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category createCategoryFromString(EDataType eDataType,
			String initialValue) {
		Category result = Category.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue
					+ "' is not a valid enumerator of '" + eDataType.getName()
					+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCategoryToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CinemaManagementSoftwarePackage getCinemaManagementSoftwarePackage() {
		return (CinemaManagementSoftwarePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CinemaManagementSoftwarePackage getPackage() {
		return CinemaManagementSoftwarePackage.eINSTANCE;
	}

} //CinemaManagementSoftwareFactoryImpl
