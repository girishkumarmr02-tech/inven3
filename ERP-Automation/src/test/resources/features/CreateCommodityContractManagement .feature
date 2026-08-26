
@XBS_Commodity_Contract_Management
Feature: Commodity Contract Management
  As a Contract Manager.I want to create a Commodity Contract with only the mandatory fields
  So that I can quickly onboard a new supplier agreement without unnecessary data entry.


  @XBS_Commodity_Contract_Management_Flow @smoke @regression
  Scenario: Create Commodity Contract Management end to end flow with only mandatory fields

    Given open browser

    When enter the user name as "username"
    When enter the user password as "password"
    Then the user should be navigated to the dashboard
