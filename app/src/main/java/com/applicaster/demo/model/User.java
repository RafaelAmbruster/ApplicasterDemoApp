package com.applicaster.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *This POJO was generated whit http://www.jsonschema2pojo.org/
 * */

@DatabaseTable(tableName = "User")
public class User extends AbstractIdentifier{

    @DatabaseField
    @SerializedName("name")
    @Expose
    private String name;

    @DatabaseField
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;

    @DatabaseField
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;

    @DatabaseField
    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;

    @SerializedName("id_str")
    @Expose
    private String idStr;

    @SerializedName("screen_name")
    @Expose
    private String screenName;

    @DatabaseField
    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("friends_count")
    @Expose
    private Integer friendsCount;

    @SerializedName("listed_count")
    @Expose
    private Integer listedCount;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("favourites_count")
    @Expose
    private Integer favouritesCount;

    @SerializedName("geo_enabled")
    @Expose
    private Boolean geoEnabled;

    @SerializedName("verified")
    @Expose
    private Boolean verified;

    @SerializedName("statuses_count")
    @Expose
    private Integer statusesCount;

    @SerializedName("lang")
    @Expose
    private String lang;

    @SerializedName("contributors_enabled")
    @Expose
    private Boolean contributorsEnabled;

    @SerializedName("is_translator")
    @Expose
    private Boolean isTranslator;

    @SerializedName("is_translation_enabled")
    @Expose
    private Boolean isTranslationEnabled;

    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;

    @SerializedName("profile_background_image_url")
    @Expose
    private String profileBackgroundImageUrl;

    @SerializedName("profile_background_image_url_https")
    @Expose
    private String profileBackgroundImageUrlHttps;

    @SerializedName("profile_background_tile")
    @Expose
    private Boolean profileBackgroundTile;

    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;

    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;

    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;

    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;

    @SerializedName("profile_use_background_image")
    @Expose
    private Boolean profileUseBackgroundImage;

    @SerializedName("has_extended_profile")
    @Expose
    private Boolean hasExtendedProfile;

    @SerializedName("default_profile")
    @Expose
    private Boolean defaultProfile;

    @SerializedName("default_profile_image")
    @Expose
    private Boolean defaultProfileImage;

    @SerializedName("following")
    @Expose
    private Boolean following;

    @SerializedName("follow_request_sent")
    @Expose
    private Boolean followRequestSent;

    @SerializedName("notifications")
    @Expose
    private Boolean notifications;

    @SerializedName("translator_type")
    @Expose
    private String translatorType;

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Integer getListedCount() {
        return listedCount;
    }

    public void setListedCount(Integer listedCount) {
        this.listedCount = listedCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Integer getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(Integer statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public Boolean getIsTranslator() {
        return isTranslator;
    }

    public void setIsTranslator(Boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    public Boolean getIsTranslationEnabled() {
        return isTranslationEnabled;
    }

    public void setIsTranslationEnabled(Boolean isTranslationEnabled) {
        this.isTranslationEnabled = isTranslationEnabled;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public Boolean getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(Boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public Boolean getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public Boolean getHasExtendedProfile() {
        return hasExtendedProfile;
    }

    public void setHasExtendedProfile(Boolean hasExtendedProfile) {
        this.hasExtendedProfile = hasExtendedProfile;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public Boolean getDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(Boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public Boolean getFollowing() {
        return following;
    }

    public void setFollowing(Boolean following) {
        this.following = following;
    }

    public Boolean getFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(Boolean followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public Boolean getNotifications() {
        return notifications;
    }

    public void setNotifications(Boolean notifications) {
        this.notifications = notifications;
    }

    public String getTranslatorType() {
        return translatorType;
    }

    public void setTranslatorType(String translatorType) {
        this.translatorType = translatorType;
    }

}
