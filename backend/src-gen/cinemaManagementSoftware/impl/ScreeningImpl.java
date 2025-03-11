/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.CinemaHall;
import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.Movie;
import cinemaManagementSoftware.Screening;

import java.lang.reflect.InvocationTargetException;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Screening</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.impl.ScreeningImpl#getMovie <em>Movie</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.ScreeningImpl#getHall <em>Hall</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.ScreeningImpl#getDate <em>Date</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.ScreeningImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.ScreeningImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.ScreeningImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScreeningImpl extends MinimalEObjectImpl.Container implements Screening {
	/**
	 * The cached value of the '{@link #getMovie() <em>Movie</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovie()
	 * @generated
	 * @ordered
	 */
	protected Movie movie;

	/**
	 * The cached value of the '{@link #getHall() <em>Hall</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHall()
	 * @generated
	 * @ordered
	 */
	protected CinemaHall hall;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final double START_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected double startTime = START_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected static final double END_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected double endTime = END_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScreeningImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinemaManagementSoftwarePackage.Literals.SCREENING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Movie getMovie() {
		if (movie != null && movie.eIsProxy()) {
			InternalEObject oldMovie = (InternalEObject) movie;
			movie = (Movie) eResolveProxy(oldMovie);
			if (movie != oldMovie) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CinemaManagementSoftwarePackage.SCREENING__MOVIE, oldMovie, movie));
			}
		}
		return movie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Movie basicGetMovie() {
		return movie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMovie(Movie newMovie) {
		Movie oldMovie = movie;
		movie = newMovie;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.SCREENING__MOVIE,
					oldMovie, movie));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CinemaHall getHall() {
		if (hall != null && hall.eIsProxy()) {
			InternalEObject oldHall = (InternalEObject) hall;
			hall = (CinemaHall) eResolveProxy(oldHall);
			if (hall != oldHall) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CinemaManagementSoftwarePackage.SCREENING__HALL, oldHall, hall));
			}
		}
		return hall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CinemaHall basicGetHall() {
		return hall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHall(CinemaHall newHall) {
		CinemaHall oldHall = hall;
		hall = newHall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.SCREENING__HALL,
					oldHall, hall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.SCREENING__DATE,
					oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartTime() {
		return startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartTime(double newStartTime) {
		double oldStartTime = startTime;
		startTime = newStartTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.SCREENING__START_TIME,
					oldStartTime, startTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEndTime() {
		return endTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndTime(double newEndTime) {
		double oldEndTime = endTime;
		endTime = newEndTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.SCREENING__END_TIME,
					oldEndTime, endTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.SCREENING__ID, oldId,
					id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void hasStarted() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void numReservations() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void numBookings() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.SCREENING__MOVIE:
			if (resolve)
				return getMovie();
			return basicGetMovie();
		case CinemaManagementSoftwarePackage.SCREENING__HALL:
			if (resolve)
				return getHall();
			return basicGetHall();
		case CinemaManagementSoftwarePackage.SCREENING__DATE:
			return getDate();
		case CinemaManagementSoftwarePackage.SCREENING__START_TIME:
			return getStartTime();
		case CinemaManagementSoftwarePackage.SCREENING__END_TIME:
			return getEndTime();
		case CinemaManagementSoftwarePackage.SCREENING__ID:
			return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.SCREENING__MOVIE:
			setMovie((Movie) newValue);
			return;
		case CinemaManagementSoftwarePackage.SCREENING__HALL:
			setHall((CinemaHall) newValue);
			return;
		case CinemaManagementSoftwarePackage.SCREENING__DATE:
			setDate((Date) newValue);
			return;
		case CinemaManagementSoftwarePackage.SCREENING__START_TIME:
			setStartTime((Double) newValue);
			return;
		case CinemaManagementSoftwarePackage.SCREENING__END_TIME:
			setEndTime((Double) newValue);
			return;
		case CinemaManagementSoftwarePackage.SCREENING__ID:
			setId((Integer) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.SCREENING__MOVIE:
			setMovie((Movie) null);
			return;
		case CinemaManagementSoftwarePackage.SCREENING__HALL:
			setHall((CinemaHall) null);
			return;
		case CinemaManagementSoftwarePackage.SCREENING__DATE:
			setDate(DATE_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.SCREENING__START_TIME:
			setStartTime(START_TIME_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.SCREENING__END_TIME:
			setEndTime(END_TIME_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.SCREENING__ID:
			setId(ID_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.SCREENING__MOVIE:
			return movie != null;
		case CinemaManagementSoftwarePackage.SCREENING__HALL:
			return hall != null;
		case CinemaManagementSoftwarePackage.SCREENING__DATE:
			return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
		case CinemaManagementSoftwarePackage.SCREENING__START_TIME:
			return startTime != START_TIME_EDEFAULT;
		case CinemaManagementSoftwarePackage.SCREENING__END_TIME:
			return endTime != END_TIME_EDEFAULT;
		case CinemaManagementSoftwarePackage.SCREENING__ID:
			return id != ID_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case CinemaManagementSoftwarePackage.SCREENING___HAS_STARTED:
			hasStarted();
			return null;
		case CinemaManagementSoftwarePackage.SCREENING___NUM_RESERVATIONS:
			numReservations();
			return null;
		case CinemaManagementSoftwarePackage.SCREENING___NUM_BOOKINGS:
			numBookings();
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (date: ");
		result.append(date);
		result.append(", startTime: ");
		result.append(startTime);
		result.append(", endTime: ");
		result.append(endTime);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //ScreeningImpl
