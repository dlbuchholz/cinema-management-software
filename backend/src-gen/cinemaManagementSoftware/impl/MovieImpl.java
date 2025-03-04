/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.Movie;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Movie</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.impl.MovieImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.MovieImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.MovieImpl#getLength <em>Length</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.MovieImpl#getId <em>Id</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.MovieImpl#getGenre <em>Genre</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MovieImpl extends MinimalEObjectImpl.Container implements Movie {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final double LENGTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected double length = LENGTH_EDEFAULT;

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
	 * The default value of the '{@link #getGenre() <em>Genre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenre()
	 * @generated
	 * @ordered
	 */
	protected static final String GENRE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGenre() <em>Genre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenre()
	 * @generated
	 * @ordered
	 */
	protected String genre = GENRE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovieImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinemaManagementSoftwarePackage.Literals.MOVIE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.MOVIE__TITLE, oldTitle,
					title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.MOVIE__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLength(double newLength) {
		double oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.MOVIE__LENGTH, oldLength,
					length));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.MOVIE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGenre() {
		return genre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGenre(String newGenre) {
		String oldGenre = genre;
		genre = newGenre;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.MOVIE__GENRE, oldGenre,
					genre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.MOVIE__TITLE:
			return getTitle();
		case CinemaManagementSoftwarePackage.MOVIE__DESCRIPTION:
			return getDescription();
		case CinemaManagementSoftwarePackage.MOVIE__LENGTH:
			return getLength();
		case CinemaManagementSoftwarePackage.MOVIE__ID:
			return getId();
		case CinemaManagementSoftwarePackage.MOVIE__GENRE:
			return getGenre();
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
		case CinemaManagementSoftwarePackage.MOVIE__TITLE:
			setTitle((String) newValue);
			return;
		case CinemaManagementSoftwarePackage.MOVIE__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case CinemaManagementSoftwarePackage.MOVIE__LENGTH:
			setLength((Double) newValue);
			return;
		case CinemaManagementSoftwarePackage.MOVIE__ID:
			setId((Integer) newValue);
			return;
		case CinemaManagementSoftwarePackage.MOVIE__GENRE:
			setGenre((String) newValue);
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
		case CinemaManagementSoftwarePackage.MOVIE__TITLE:
			setTitle(TITLE_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.MOVIE__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.MOVIE__LENGTH:
			setLength(LENGTH_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.MOVIE__ID:
			setId(ID_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.MOVIE__GENRE:
			setGenre(GENRE_EDEFAULT);
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
		case CinemaManagementSoftwarePackage.MOVIE__TITLE:
			return TITLE_EDEFAULT == null ? title != null
					: !TITLE_EDEFAULT.equals(title);
		case CinemaManagementSoftwarePackage.MOVIE__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null
					: !DESCRIPTION_EDEFAULT.equals(description);
		case CinemaManagementSoftwarePackage.MOVIE__LENGTH:
			return length != LENGTH_EDEFAULT;
		case CinemaManagementSoftwarePackage.MOVIE__ID:
			return id != ID_EDEFAULT;
		case CinemaManagementSoftwarePackage.MOVIE__GENRE:
			return GENRE_EDEFAULT == null ? genre != null
					: !GENRE_EDEFAULT.equals(genre);
		}
		return super.eIsSet(featureID);
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
		result.append(" (title: ");
		result.append(title);
		result.append(", description: ");
		result.append(description);
		result.append(", length: ");
		result.append(length);
		result.append(", id: ");
		result.append(id);
		result.append(", genre: ");
		result.append(genre);
		result.append(')');
		return result.toString();
	}

} //MovieImpl
