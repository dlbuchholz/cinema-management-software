/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.Category;
import cinemaManagementSoftware.Cinema;
import cinemaManagementSoftware.CinemaHall;
import cinemaManagementSoftware.CinemaManagementSoftwareFactory;
import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.CinemaOwner;
import cinemaManagementSoftware.Customer;
import cinemaManagementSoftware.Movie;
import cinemaManagementSoftware.Person;
import cinemaManagementSoftware.Screening;
import cinemaManagementSoftware.Seat;
import cinemaManagementSoftware.SeatingRow;
import cinemaManagementSoftware.Ticket;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CinemaManagementSoftwarePackageImpl extends EPackageImpl
		implements CinemaManagementSoftwarePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cinemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cinemaOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ticketEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass screeningEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movieEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cinemaHallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seatingRowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum categoryEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CinemaManagementSoftwarePackageImpl() {
		super(eNS_URI, CinemaManagementSoftwareFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CinemaManagementSoftwarePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CinemaManagementSoftwarePackage init() {
		if (isInited)
			return (CinemaManagementSoftwarePackage) EPackage.Registry.INSTANCE
					.getEPackage(CinemaManagementSoftwarePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCinemaManagementSoftwarePackage = EPackage.Registry.INSTANCE
				.get(eNS_URI);
		CinemaManagementSoftwarePackageImpl theCinemaManagementSoftwarePackage = registeredCinemaManagementSoftwarePackage instanceof CinemaManagementSoftwarePackageImpl
				? (CinemaManagementSoftwarePackageImpl) registeredCinemaManagementSoftwarePackage
				: new CinemaManagementSoftwarePackageImpl();

		isInited = true;

		// Create package meta-data objects
		theCinemaManagementSoftwarePackage.createPackageContents();

		// Initialize created meta-data
		theCinemaManagementSoftwarePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCinemaManagementSoftwarePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CinemaManagementSoftwarePackage.eNS_URI,
				theCinemaManagementSoftwarePackage);
		return theCinemaManagementSoftwarePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCinema() {
		return cinemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCinema_Id() {
		return (EAttribute) cinemaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCinema_Name() {
		return (EAttribute) cinemaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCinema_Location() {
		return (EAttribute) cinemaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCinema_Owner() {
		return (EReference) cinemaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCinema_Hall() {
		return (EReference) cinemaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCinema__TotalIncome() {
		return cinemaEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPerson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPerson_Id() {
		return (EAttribute) personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCustomer() {
		return customerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCustomer_Ticket() {
		return (EReference) customerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCustomer_Email() {
		return (EAttribute) customerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCustomer_Telephone() {
		return (EAttribute) customerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCinemaOwner() {
		return cinemaOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTicket() {
		return ticketEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTicket_Screening() {
		return (EReference) ticketEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTicket_Seat() {
		return (EReference) ticketEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTicket_Price() {
		return (EAttribute) ticketEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTicket_IsBooked() {
		return (EAttribute) ticketEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTicket_Id() {
		return (EAttribute) ticketEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScreening() {
		return screeningEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScreening_Movie() {
		return (EReference) screeningEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScreening_Hall() {
		return (EReference) screeningEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScreening_Date() {
		return (EAttribute) screeningEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScreening_StartTime() {
		return (EAttribute) screeningEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScreening_EndTime() {
		return (EAttribute) screeningEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScreening_Id() {
		return (EAttribute) screeningEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getScreening__HasStarted() {
		return screeningEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getScreening__NumReservations() {
		return screeningEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getScreening__NumBookings() {
		return screeningEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMovie() {
		return movieEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMovie_Name() {
		return (EAttribute) movieEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMovie_Description() {
		return (EAttribute) movieEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMovie_Length() {
		return (EAttribute) movieEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMovie_Id() {
		return (EAttribute) movieEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCinemaHall() {
		return cinemaHallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCinemaHall_Row() {
		return (EReference) cinemaHallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCinemaHall_Id() {
		return (EAttribute) cinemaHallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCinemaHall__IsConfigComplete() {
		return cinemaHallEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSeatingRow() {
		return seatingRowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSeatingRow_Cinemahall() {
		return (EReference) seatingRowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSeatingRow_Category() {
		return (EAttribute) seatingRowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSeatingRow_Seat() {
		return (EReference) seatingRowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSeatingRow_Id() {
		return (EAttribute) seatingRowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSeat() {
		return seatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSeat_Row() {
		return (EReference) seatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSeat_Id() {
		return (EAttribute) seatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCategory() {
		return categoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CinemaManagementSoftwareFactory getCinemaManagementSoftwareFactory() {
		return (CinemaManagementSoftwareFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		cinemaEClass = createEClass(CINEMA);
		createEAttribute(cinemaEClass, CINEMA__ID);
		createEAttribute(cinemaEClass, CINEMA__NAME);
		createEAttribute(cinemaEClass, CINEMA__LOCATION);
		createEReference(cinemaEClass, CINEMA__OWNER);
		createEReference(cinemaEClass, CINEMA__HALL);
		createEOperation(cinemaEClass, CINEMA___TOTAL_INCOME);

		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__ID);

		customerEClass = createEClass(CUSTOMER);
		createEReference(customerEClass, CUSTOMER__TICKET);
		createEAttribute(customerEClass, CUSTOMER__EMAIL);
		createEAttribute(customerEClass, CUSTOMER__TELEPHONE);

		cinemaOwnerEClass = createEClass(CINEMA_OWNER);

		ticketEClass = createEClass(TICKET);
		createEReference(ticketEClass, TICKET__SCREENING);
		createEReference(ticketEClass, TICKET__SEAT);
		createEAttribute(ticketEClass, TICKET__PRICE);
		createEAttribute(ticketEClass, TICKET__IS_BOOKED);
		createEAttribute(ticketEClass, TICKET__ID);

		screeningEClass = createEClass(SCREENING);
		createEReference(screeningEClass, SCREENING__MOVIE);
		createEReference(screeningEClass, SCREENING__HALL);
		createEAttribute(screeningEClass, SCREENING__DATE);
		createEAttribute(screeningEClass, SCREENING__START_TIME);
		createEAttribute(screeningEClass, SCREENING__END_TIME);
		createEAttribute(screeningEClass, SCREENING__ID);
		createEOperation(screeningEClass, SCREENING___HAS_STARTED);
		createEOperation(screeningEClass, SCREENING___NUM_RESERVATIONS);
		createEOperation(screeningEClass, SCREENING___NUM_BOOKINGS);

		movieEClass = createEClass(MOVIE);
		createEAttribute(movieEClass, MOVIE__NAME);
		createEAttribute(movieEClass, MOVIE__DESCRIPTION);
		createEAttribute(movieEClass, MOVIE__LENGTH);
		createEAttribute(movieEClass, MOVIE__ID);

		cinemaHallEClass = createEClass(CINEMA_HALL);
		createEReference(cinemaHallEClass, CINEMA_HALL__ROW);
		createEAttribute(cinemaHallEClass, CINEMA_HALL__ID);
		createEOperation(cinemaHallEClass, CINEMA_HALL___IS_CONFIG_COMPLETE);

		seatingRowEClass = createEClass(SEATING_ROW);
		createEReference(seatingRowEClass, SEATING_ROW__CINEMAHALL);
		createEAttribute(seatingRowEClass, SEATING_ROW__CATEGORY);
		createEReference(seatingRowEClass, SEATING_ROW__SEAT);
		createEAttribute(seatingRowEClass, SEATING_ROW__ID);

		seatEClass = createEClass(SEAT);
		createEReference(seatEClass, SEAT__ROW);
		createEAttribute(seatEClass, SEAT__ID);

		// Create enums
		categoryEEnum = createEEnum(CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		customerEClass.getESuperTypes().add(this.getPerson());
		cinemaOwnerEClass.getESuperTypes().add(this.getPerson());

		// Initialize classes, features, and operations; add parameters
		initEClass(cinemaEClass, Cinema.class, "Cinema", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCinema_Id(), ecorePackage.getELong(), "id", null, 0,
				1, Cinema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCinema_Name(), ecorePackage.getEString(), "name",
				null, 0, 1, Cinema.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getCinema_Location(), ecorePackage.getEString(),
				"location", null, 0, 1, Cinema.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getCinema_Owner(), this.getCinemaOwner(), null, "owner",
				null, 1, 1, Cinema.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCinema_Hall(), this.getCinemaHall(), null, "hall",
				null, 1, -1, Cinema.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getCinema__TotalIncome(), null, "totalIncome", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		initEClass(personEClass, Person.class, "Person", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_Id(), ecorePackage.getEInt(), "id", null, 0, 1,
				Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customerEClass, Customer.class, "Customer", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCustomer_Ticket(), this.getTicket(), null, "ticket",
				null, 1, -1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomer_Email(), ecorePackage.getEString(), "email",
				null, 0, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getCustomer_Telephone(), ecorePackage.getEString(),
				"telephone", null, 0, 1, Customer.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(cinemaOwnerEClass, CinemaOwner.class, "CinemaOwner",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ticketEClass, Ticket.class, "Ticket", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTicket_Screening(), this.getScreening(), null,
				"screening", null, 1, 1, Ticket.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTicket_Seat(), this.getSeat(), null, "seat", null, 1,
				1, Ticket.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTicket_Price(), ecorePackage.getEDouble(), "price",
				null, 0, 1, Ticket.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getTicket_IsBooked(), ecorePackage.getEBoolean(),
				"isBooked", null, 0, 1, Ticket.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTicket_Id(), ecorePackage.getEInt(), "id", null, 0, 1,
				Ticket.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(screeningEClass, Screening.class, "Screening", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScreening_Movie(), this.getMovie(), null, "movie",
				null, 1, 1, Screening.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScreening_Hall(), this.getCinemaHall(), null, "hall",
				null, 1, 1, Screening.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScreening_Date(), ecorePackage.getEDate(), "date",
				null, 0, 1, Screening.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getScreening_StartTime(), ecorePackage.getEDouble(),
				"startTime", null, 0, 1, Screening.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getScreening_EndTime(), ecorePackage.getEDouble(),
				"endTime", null, 0, 1, Screening.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getScreening_Id(), ecorePackage.getEInt(), "id", null, 0,
				1, Screening.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getScreening__HasStarted(), null, "hasStarted", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		initEOperation(getScreening__NumReservations(), null, "numReservations",
				0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getScreening__NumBookings(), null, "numBookings", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		initEClass(movieEClass, Movie.class, "Movie", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovie_Name(), ecorePackage.getEString(), "name", null,
				0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Description(), ecorePackage.getEString(),
				"description", null, 0, 1, Movie.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Length(), ecorePackage.getEDouble(), "length",
				null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getMovie_Id(), ecorePackage.getEInt(), "id", null, 0, 1,
				Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cinemaHallEClass, CinemaHall.class, "CinemaHall",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCinemaHall_Row(), this.getSeatingRow(),
				this.getSeatingRow_Cinemahall(), "row", null, 1, -1,
				CinemaHall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getCinemaHall_Id(), ecorePackage.getEInt(), "id", null,
				0, 1, CinemaHall.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEOperation(getCinemaHall__IsConfigComplete(), null,
				"isConfigComplete", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(seatingRowEClass, SeatingRow.class, "SeatingRow",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSeatingRow_Cinemahall(), this.getCinemaHall(),
				this.getCinemaHall_Row(), "cinemahall", null, 1, 1,
				SeatingRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeatingRow_Category(), this.getCategory(), "category",
				null, 0, 1, SeatingRow.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getSeatingRow_Seat(), this.getSeat(), this.getSeat_Row(),
				"seat", null, 1, -1, SeatingRow.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeatingRow_Id(), ecorePackage.getEInt(), "id", null,
				0, 1, SeatingRow.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(seatEClass, Seat.class, "Seat", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSeat_Row(), this.getSeatingRow(),
				this.getSeatingRow_Seat(), "row", null, 1, 1, Seat.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getSeat_Id(), ecorePackage.getEInt(), "id", null, 0, 1,
				Seat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(categoryEEnum, Category.class, "Category");
		addEEnumLiteral(categoryEEnum, Category.PARQUET);
		addEEnumLiteral(categoryEEnum, Category.LOGE);
		addEEnumLiteral(categoryEEnum, Category.LOGE_SERVICE);

		// Create resource
		createResource(eNS_URI);
	}

} //CinemaManagementSoftwarePackageImpl
