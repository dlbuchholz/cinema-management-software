/**
 */
package cinemaManagementSoftware;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Screening</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.Screening#getMovie <em>Movie</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Screening#getHall <em>Hall</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Screening#getDate <em>Date</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Screening#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Screening#getEndTime <em>End Time</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Screening#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getScreening()
 * @model
 * @generated
 */
public interface Screening extends EObject {
	/**
	 * Returns the value of the '<em><b>Movie</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movie</em>' reference.
	 * @see #setMovie(Movie)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getScreening_Movie()
	 * @model required="true"
	 * @generated
	 */
	Movie getMovie();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Screening#getMovie <em>Movie</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Movie</em>' reference.
	 * @see #getMovie()
	 * @generated
	 */
	void setMovie(Movie value);

	/**
	 * Returns the value of the '<em><b>Hall</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hall</em>' reference.
	 * @see #setHall(CinemaHall)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getScreening_Hall()
	 * @model required="true"
	 * @generated
	 */
	CinemaHall getHall();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Screening#getHall <em>Hall</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hall</em>' reference.
	 * @see #getHall()
	 * @generated
	 */
	void setHall(CinemaHall value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getScreening_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Screening#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(double)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getScreening_StartTime()
	 * @model
	 * @generated
	 */
	double getStartTime();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Screening#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(double value);

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see #setEndTime(double)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getScreening_EndTime()
	 * @model
	 * @generated
	 */
	double getEndTime();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Screening#getEndTime <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' attribute.
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(double value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getScreening_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Screening#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void hasStarted();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void numReservations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void numBookings();

} // Screening
