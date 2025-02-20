/**
 */
package cinemaManagementSoftware.util;

import cinemaManagementSoftware.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage
 * @generated
 */
public class CinemaManagementSoftwareAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CinemaManagementSoftwarePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CinemaManagementSoftwareAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CinemaManagementSoftwarePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CinemaManagementSoftwareSwitch<Adapter> modelSwitch = new CinemaManagementSoftwareSwitch<Adapter>() {
		@Override
		public Adapter caseCinema(Cinema object) {
			return createCinemaAdapter();
		}

		@Override
		public Adapter casePerson(Person object) {
			return createPersonAdapter();
		}

		@Override
		public Adapter caseCustomer(Customer object) {
			return createCustomerAdapter();
		}

		@Override
		public Adapter caseCinemaOwner(CinemaOwner object) {
			return createCinemaOwnerAdapter();
		}

		@Override
		public Adapter caseTicket(Ticket object) {
			return createTicketAdapter();
		}

		@Override
		public Adapter caseScreening(Screening object) {
			return createScreeningAdapter();
		}

		@Override
		public Adapter caseMovie(Movie object) {
			return createMovieAdapter();
		}

		@Override
		public Adapter caseCinemaHall(CinemaHall object) {
			return createCinemaHallAdapter();
		}

		@Override
		public Adapter caseSeatingRow(SeatingRow object) {
			return createSeatingRowAdapter();
		}

		@Override
		public Adapter caseSeat(Seat object) {
			return createSeatAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link cinemaManagementSoftware.Cinema <em>Cinema</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cinemaManagementSoftware.Cinema
	 * @generated
	 */
	public Adapter createCinemaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cinemaManagementSoftware.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cinemaManagementSoftware.Person
	 * @generated
	 */
	public Adapter createPersonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cinemaManagementSoftware.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cinemaManagementSoftware.Customer
	 * @generated
	 */
	public Adapter createCustomerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cinemaManagementSoftware.CinemaOwner <em>Cinema Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cinemaManagementSoftware.CinemaOwner
	 * @generated
	 */
	public Adapter createCinemaOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cinemaManagementSoftware.Ticket <em>Ticket</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cinemaManagementSoftware.Ticket
	 * @generated
	 */
	public Adapter createTicketAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cinemaManagementSoftware.Screening <em>Screening</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cinemaManagementSoftware.Screening
	 * @generated
	 */
	public Adapter createScreeningAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cinemaManagementSoftware.Movie <em>Movie</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cinemaManagementSoftware.Movie
	 * @generated
	 */
	public Adapter createMovieAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cinemaManagementSoftware.CinemaHall <em>Cinema Hall</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cinemaManagementSoftware.CinemaHall
	 * @generated
	 */
	public Adapter createCinemaHallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cinemaManagementSoftware.SeatingRow <em>Seating Row</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cinemaManagementSoftware.SeatingRow
	 * @generated
	 */
	public Adapter createSeatingRowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cinemaManagementSoftware.Seat <em>Seat</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cinemaManagementSoftware.Seat
	 * @generated
	 */
	public Adapter createSeatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CinemaManagementSoftwareAdapterFactory
